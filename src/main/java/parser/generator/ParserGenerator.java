package parser.generator;

import parser.utils.Grammar;
import parser.utils.Rule;
import parser.utils.RuleBranch;
import parser.utils.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ParserGenerator {

    private static final String parserTemplate =
            """
                    %s
                    
                    import java.io.InputStream;
                    import java.text.ParseException;
                    import java.util.Set;
                    
                    import org.example.utils.Tree;
                    
                    public class %sParser {
                                        
                        private %sLexicalAnalyzer lex;
                    
                    %s
                    
                        public Tree<%s> parse(InputStream is) throws ParseException {
                            lex = new %sLexicalAnalyzer(is);
                            lex.nextToken();
                            return start();
                        }
                    
                    %s
                    
                    }
                    """;

    private static final String ruleTemplate =
            """
                    Tree<%s> %s() throws ParseException {
                    %s
                        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
                    }
                    """;

    private static final String conditionTemplate =
            """
                    if (%s) {
                    %s
                        Tree<%s> result = new Tree<>("%s", %s);
                        result.setValue(%s);
                        return result;
                    }""";

    private static final String evalTokenTemplate =
            """
                        if (lex.curToken() != %sToken.%s) {
                            throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
                        }
                        Tree<%s> %s = new Tree<>("%s");
                        %s.setValue(%s);
                        lex.nextToken();""";

    private static final String emptyBranchTemplate =
            """
                        if (%s) {
                            Tree<%s> result = new Tree<>("eps");
                            result.setValue(%s);
                            return result;
                        }""";

    public static void generateParser(Path path, Grammar grammar) {
        Map<String, Set<String>> firsts = findFirsts(grammar);
        Map<String, Set<String>> follows = findFollows(grammar, firsts);
        List<String> rules = new ArrayList<>();
        for (Rule rule : grammar.getRules()) {
            List<String> conditions = new ArrayList<>();
            List<RuleBranch> branches = rule.getBranches();
            for (RuleBranch branch : branches) {
                String condition = getFirst1(firsts, follows, branch.getElements(), rule.getLeft())
                        .stream()
                        .map(t -> String.format("%sToken.%s", grammar.getName(), t))
                        .collect(Collectors.joining(", ", "Set.of(", ").contains(lex.curToken())"));
                if ("EPS".equals(branch.getElements().get(0))) {
                    conditions.add(String.format(emptyBranchTemplate, condition, grammar.getVariableType(), grammar.getEpsRule()));
                    continue;
                }
                List<String> nodes = new ArrayList<>();
                List<String> parts = new ArrayList<>();
                List<String> elements = branch.getElements();
                for (String e : elements) {
                    if (e.equals(e.toUpperCase())) {
                        String tokenTemplate = "null";
                        for (Token token : grammar.getTokens()) {
                            if (token.getName().equals(e)) {
                                tokenTemplate = token.getCode();
                            }
                        }
                        parts.add(String.format(evalTokenTemplate, grammar.getName(), e, grammar.getVariableType(),
                                e, e, e, String.format(tokenTemplate, "lex.curValue()")));
                    } else {
                        parts.add(String.format("Tree<%s> %s = %s();", grammar.getVariableType(), e, e));
                    }
                    nodes.add(e);
                }
                String conditionsInBranch = shiftCode(String.join("\n", parts));
                String children = String.join(", ", nodes);
                conditions.add(String.format(conditionTemplate, condition, conditionsInBranch,
                        grammar.getVariableType(),
                        rule.getLeft(), children, branch.getCode()));
            }
            String elseIf = String.join(" else ", conditions);
            String resultConditions = shiftCode(elseIf);
            rules.add(shiftCode(String.format(ruleTemplate, grammar.getVariableType(), rule.getLeft(), resultConditions)));
        }
        String body = String.join("\n\n", rules);

        Path tokenPath = path.resolve(grammar.getName() + "Parser.java");
        try (var writer = Files.newBufferedWriter(tokenPath)) {
            writer.write(String.format(parserTemplate, String.join("\n", grammar.getHeaders()), grammar.getName(),
                    grammar.getName(), body, grammar.getVariableType(), grammar.getName(), grammar.getCodePart()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String shiftCode(String code) {
        return Arrays.stream(code.split("\n")).map(s -> "    " + s).collect(Collectors.joining("\n"));
    }

    private static Map<String, Set<String>> findFirsts(Grammar grammar) {
        Map<String, Set<String>> firsts = new HashMap<>();
        for (Rule rule : grammar.getRules()) {
            firsts.put(rule.getLeft(), new HashSet<>());
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Rule rule : grammar.getRules()) {
                Set<String> firstsByName = firsts.get(rule.getLeft());
                int size = firstsByName.size();
                for (RuleBranch ruleBranch : rule.getBranches()) {
                    firstsByName.addAll(getFirsts(firsts, ruleBranch.getElements()));
                }
                changed |= size < firstsByName.size();
            }
        }
        return firsts;
    }

    private static Map<String, Set<String>> findFollows(Grammar grammar, Map<String, Set<String>> firsts) {
        Map<String, Set<String>> follows = new HashMap<>();
        for (Rule rule : grammar.getRules()) {
            follows.put(rule.getLeft(), new HashSet<>());
        }
        follows.get("start").add("END");
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Rule rule : grammar.getRules()) {
                for (RuleBranch ruleBranch : rule.getBranches()) {
                    List<String> elements = ruleBranch.getElements();
                    for (int i = 0; i < elements.size(); i++) {
                        if (elements.get(i).equals(elements.get(i).toLowerCase())) {
                            Set<String> followsByRule = follows.get(elements.get(i));
                            int size = followsByRule.size();
                            Set<String> firstsY = new HashSet<>(getFirsts(firsts, elements.subList(i + 1, elements.size())));
                            if (firstsY.contains("EPS")) {
                                followsByRule.addAll(follows.get(rule.getLeft()));
                                firstsY.remove("EPS");
                            }
                            followsByRule.addAll(firstsY);
                            changed |= size < followsByRule.size();
                        }
                    }
                }
            }
        }
        return follows;
    }

    private static Set<String> getFirsts(Map<String, Set<String>> firsts, List<String> elements) {
        if (elements.size() == 0) {
            return Set.of("EPS");
        }
        String e = elements.get(0);
        if (e.equals(e.toUpperCase())) {
            return Set.of(e);
        }
        Set<String> firstA = new HashSet<>(firsts.get(e));
        Set<String> result = new HashSet<>();
        if (firstA.contains("EPS")) {
            result.addAll(getFirsts(firsts, elements.subList(1, elements.size())));
            firstA.remove("EPS");
        }
        result.addAll(firstA);
        return result;
    }

    private static Set<String> getFirst1(Map<String, Set<String>> firsts, Map<String, Set<String>> follows, List<String> elements, String base) {
        Set<String> firstsA = new HashSet<>(getFirsts(firsts, elements));
        Set<String> result = new HashSet<>();
        if (firstsA.contains("EPS")) {
            result.addAll(follows.get(base));
            firstsA.remove("EPS");
        }
        result.addAll(firstsA);
        return result;
    }

}
