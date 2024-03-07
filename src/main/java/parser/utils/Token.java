package parser.utils;

import parser.grammar.GrammarParser;

public class Token {

    private final String name;
    private final String regex;
    private final boolean isSkip;
    private final String code;

    public Token(GrammarParser.TokenContext tokenContext) {
        this.name = tokenContext.name.getText();

        String s = tokenContext.regex.getText();
        this.regex = String.format("^%s$", s.substring(1, s.length() - 1));

        this.isSkip = tokenContext.tail.val.getText().contains("skip");

        GrammarParser.CalcResultContext calcResult = tokenContext.tail.calculation;
        if (calcResult.val != null) {
            s = calcResult.val.getText();
            this.code = s.substring(1, s.length() - 1);
        } else {
            this.code = "null";
        }
    }

    public Token(String name, String regex, boolean isSkip, String code) {
        this.name = name;
        this.regex = regex;
        this.isSkip = isSkip;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getRegex() {
        return regex;
    }

    public boolean matches(String s) {
        return s.matches(regex);
    }

    public boolean isSkip() {
        return isSkip;
    }

    public String getCode() {
        return code;
    }
}
