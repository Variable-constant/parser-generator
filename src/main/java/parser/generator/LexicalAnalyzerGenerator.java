package parser.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import parser.utils.Grammar;
import parser.utils.Token;

public class LexicalAnalyzerGenerator {

    private static final String lexicalAnalyzerTemplate =
            """
                    %s

                    import java.io.IOException;
                    import java.io.InputStream;
                    import java.text.ParseException;
                    import java.util.ArrayList;
                    import java.util.List;

                    import org.example.utils.Grammar;
                    import org.example.utils.Token;

                    public class %sLexicalAnalyzer {
                        private final InputStream is;
                        private int curChar;
                        private int curPos;
                        private %sToken curToken;
                        private final List<Token> tokenList;
                        private String curValue = "";

                        public %sLexicalAnalyzer(InputStream is) throws ParseException {
                            this.is = is;
                            this.tokenList = new ArrayList<>();
                    %s
                            curPos = 0;
                            nextChar();
                        }

                        private void nextChar() throws ParseException {
                            curPos++;
                            try {
                                curChar = is.read();
                            } catch (IOException e) {
                                throw new ParseException(e.getMessage(), curPos);
                            }
                        }

                        public void nextToken() throws ParseException {
                            if (curChar == -1) {
                                curToken = %sToken.END;
                                return;
                            }
                            String curBlock = "";
                            int startPos = curPos;
                            boolean found = false;
                            boolean isSkip = false;
                            while (curChar != -1) {
                                curBlock += (char) curChar;
                                for (Token token : tokenList) {
                                    if (token.matches(curBlock)) {
                                        curToken = %sToken.valueOf(token.getName());
                                        is.mark(Integer.MAX_VALUE);
                                        found = true;
                                        startPos = curPos;
                                        isSkip = token.isSkip();
                                        curValue = curBlock;
                                        break;
                                    }
                                }
                                nextChar();
                            }
                            if (!found) {
                                throw new ParseException("Expected token at position " + startPos, startPos);
                            }
                            try {
                                is.reset();
                                curPos = startPos;
                                nextChar();
                                if (isSkip) {
                                    nextToken();
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e.getMessage());
                            }
                        }

                        public %sToken curToken() {
                            return curToken;
                        }

                        public int curPos() {
                            return curPos;
                        }

                        public String curValue() {
                            return curValue;
                        }

                    }
                    """;

    public static void generateLexicalAnalyzer(Path path, Grammar grammar) {
        List<String> tokens = new ArrayList<>();
        for (Token token : grammar.getTokens()) {
            tokens.add(String.format("        this.tokenList.add(new Token(\"%s\", \"%s\", %b, \"%s\"));",
                    token.getName(), token.getRegex(), token.isSkip(), token.getCode()));
        }

        String grammarName = grammar.getName();
        Path lexicalAnalyzerPath = path.resolve(grammar.getName() + "LexicalAnalyzer.java");
        try (var writer = Files.newBufferedWriter(lexicalAnalyzerPath)) {
            writer.write(String.format(lexicalAnalyzerTemplate, String.join("\n", grammar.getHeaders()), grammarName, grammarName,
                    grammarName, String.join("\n", tokens), grammarName, grammarName, grammarName));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}
