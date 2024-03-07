package parser.generator;

import parser.utils.Grammar;
import parser.utils.Token;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class TokenGenerator {

    private static final String tokenEnumTemplate =
            """
                    %s
                    
                    public enum %sToken {
                        %s
                    }
                    """;

    public static void generateTokens(Path path, Grammar grammar) {
        Path tokenPath = path.resolve(grammar.getName() + "Token.java");
        try (var writer = Files.newBufferedWriter(tokenPath)) {
            String tokenList = grammar.getTokens().stream().map(Token::getName).collect(Collectors.joining(", ", "", ", END, EPS"));
            writer.write(String.format(tokenEnumTemplate, String.join("\n", grammar.getHeaders()), grammar.getName(), tokenList));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
