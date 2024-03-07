package parser.lab3;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import parser.utils.Token;

public class Lab3LexicalAnalyzer {
    private final InputStream is;
    private int curChar;
    private int curPos;
    private Lab3Token curToken;
    private final List<Token> tokenList;
    private String curValue = "";

    public Lab3LexicalAnalyzer(InputStream is) throws ParseException {
        this.is = is;
        this.tokenList = new ArrayList<>();
        this.tokenList.add(new Token("INV", "^inv$", false, "null"));
        this.tokenList.add(new Token("FUNC", "^func$", false, "null"));
        this.tokenList.add(new Token("OP_BR", "^\\($", false, "null"));
        this.tokenList.add(new Token("CL_BR", "^\\)$", false, "null"));
        this.tokenList.add(new Token("CURLY_OP_BR", "^\\{$", false, "null"));
        this.tokenList.add(new Token("CURLY_CL_BR", "^\\}$", false, "null"));
        this.tokenList.add(new Token("VAR_DEC", "^variable$", false, "null"));
        this.tokenList.add(new Token("RETURN", "^return$", false, "null"));
        this.tokenList.add(new Token("ADD", "^\\+$", false, "null"));
        this.tokenList.add(new Token("SUB", "^-$", false, "null"));
        this.tokenList.add(new Token("MUL", "^\\*$", false, "null"));
        this.tokenList.add(new Token("DIV", "^/$", false, "null"));
        this.tokenList.add(new Token("LESS", "^<$", false, "null"));
        this.tokenList.add(new Token("GREATER", "^>$", false, "null"));
        this.tokenList.add(new Token("AND", "^and$", false, "null"));
        this.tokenList.add(new Token("OR", "^or$", false, "null"));
        this.tokenList.add(new Token("XOR", "^xor$", false, "null"));
        this.tokenList.add(new Token("ASSIGNMENT", "^=$", false, "null"));
        this.tokenList.add(new Token("EQUALS", "^==$", false, "null"));
        this.tokenList.add(new Token("PRINT", "^print$", false, "null"));
        this.tokenList.add(new Token("IF", "^if$", false, "null"));
        this.tokenList.add(new Token("ELSE", "^else$", false, "null"));
        this.tokenList.add(new Token("WHILE", "^while$", false, "null"));
        this.tokenList.add(new Token("WS", "^[\t\r\n ]+$", true, "null"));
        this.tokenList.add(new Token("NUM", "^[0-9]+$", false, "%s"));
        this.tokenList.add(new Token("VAR", "^[a-zA-Z]+$", false, "%s"));
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
            curToken = Lab3Token.END;
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
                    curToken = Lab3Token.valueOf(token.getName());
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

    public Lab3Token curToken() {
        return curToken;
    }

    public int curPos() {
        return curPos;
    }

    public String curValue() {
        return curValue;
    }

}
