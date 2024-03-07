package parser.expression;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import parser.utils.Token;

public class ExpressionLexicalAnalyzer {
    private final InputStream is;
    private int curChar;
    private int curPos;
    private ExpressionToken curToken;
    private final List<Token> tokenList;
    private String curValue = "";

    public ExpressionLexicalAnalyzer(InputStream is) throws ParseException {
        this.is = is;
        this.tokenList = new ArrayList<>();
        this.tokenList.add(new Token("NUMBER", "^[0-9]+\\.[0-9]+$", false, "wrapDouble()"));
        this.tokenList.add(new Token("POW", "^\\*\\*$", false, "null"));
        this.tokenList.add(new Token("MUL", "^\\*$", false, "null"));
        this.tokenList.add(new Token("DIV", "^/$", false, "null"));
        this.tokenList.add(new Token("ADD", "^\\+$", false, "null"));
        this.tokenList.add(new Token("SUB", "^-$", false, "null"));
        this.tokenList.add(new Token("WS", "^[\t\n\r ]+$", true, "null"));
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
            curToken = ExpressionToken.END;
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
                    curToken = ExpressionToken.valueOf(token.getName());
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

    public ExpressionToken curToken() {
        return curToken;
    }

    public int curPos() {
        return curPos;
    }

    public String curValue() {
        return curValue;
    }

}
