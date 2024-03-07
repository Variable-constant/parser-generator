package parser;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.function.Function;

import parser.expression.ExpressionParser;
import parser.grammar.GrammarLexer;
import parser.grammar.GrammarParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.UnbufferedTokenStream;
import parser.lab2.Lab2Parser;
import parser.lab3.Lab3Parser;
import parser.utils.Grammar;
import parser.utils.Tree;

public class Main {

    public static void main(String[] args) throws IOException {
//        generateGrammar("resources/expression.txt");
//        generateGrammar("resources/lab2.txt");
//        generateGrammar("resources/lab3.txt");
//        testLab2();
        testExpression();
//        testLab3();
    }

    private static void testExpression() {
        String input = "1.0 - 2.0 - 3.0";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        ExpressionParser parser = new ExpressionParser();
        try {
            Tree<Function<Double, Double>> result = parser.parse(inputStream);
            System.out.println(result.getValue().apply(0D));
            result.getDigraph();
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void testLab2() {
        String input = "var x:Array<Array<Int>>;";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        Lab2Parser parser = new Lab2Parser();
        try {
            Tree<Object> result = parser.parse(inputStream);
            result.getDigraph();
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void testLab3() {
        String input = """
                func x(a) {
                   print a
                }
                inv x(10)
                """;
        InputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        Lab3Parser parser = new Lab3Parser();
        try {
            Tree<String> result = parser.parse(inputStream);
            System.out.println(result.getValue());
            result.getDigraph();
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void generateGrammar(String fileName) throws IOException {
        InputStream is = new FileInputStream(fileName);
        ANTLRInputStream input = new ANTLRInputStream(is);
        GrammarLexer lex = new GrammarLexer(input);
        lex.setTokenFactory(new CommonTokenFactory(true));
        TokenStream tokens = new UnbufferedTokenStream<CommonToken>(lex);
        GrammarParser parser = new GrammarParser(tokens);
        parser.setBuildParseTree(false);
        GrammarParser.StartContext startContext = parser.start();

        Grammar grammar = new Grammar(startContext);
        grammar.generateParser();
    }
}
