package parser.lab2;

import java.io.InputStream;
import java.text.ParseException;
import java.util.Set;

import parser.utils.Tree;

public class Lab2Parser {

    private Lab2LexicalAnalyzer lex;

    Tree<Object> start() throws ParseException {
        if (Set.of(Lab2Token.VAR).contains(lex.curToken())) {
            if (lex.curToken() != Lab2Token.VAR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Object> VAR = new Tree<>("VAR");
            VAR.setValue(null);
            lex.nextToken();
            Tree<Object> v = v();
            if (lex.curToken() != Lab2Token.COLON) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Object> COLON = new Tree<>("COLON");
            COLON.setValue(null);
            lex.nextToken();
            Tree<Object> t = t();
            if (lex.curToken() != Lab2Token.SEMICOLON) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Object> SEMICOLON = new Tree<>("SEMICOLON");
            SEMICOLON.setValue(null);
            lex.nextToken();
            Tree<Object> result = new Tree<>("start", VAR, v, COLON, t, SEMICOLON);
            result.setValue(null);
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<Object> v() throws ParseException {
        if (Set.of(Lab2Token.NAME).contains(lex.curToken())) {
            if (lex.curToken() != Lab2Token.NAME) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Object> NAME = new Tree<>("NAME");
            NAME.setValue(null);
            lex.nextToken();
            Tree<Object> result = new Tree<>("v", NAME);
            result.setValue(null);
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<Object> t() throws ParseException {
        if (Set.of(Lab2Token.ARRAY).contains(lex.curToken())) {
            if (lex.curToken() != Lab2Token.ARRAY) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Object> ARRAY = new Tree<>("ARRAY");
            ARRAY.setValue(null);
            lex.nextToken();
            if (lex.curToken() != Lab2Token.LT) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Object> LT = new Tree<>("LT");
            LT.setValue(null);
            lex.nextToken();
            Tree<Object> t = t();
            if (lex.curToken() != Lab2Token.GT) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Object> GT = new Tree<>("GT");
            GT.setValue(null);
            lex.nextToken();
            Tree<Object> result = new Tree<>("t", ARRAY, LT, t, GT);
            result.setValue(null);
            return result;
        } else if (Set.of(Lab2Token.NAME).contains(lex.curToken())) {
            if (lex.curToken() != Lab2Token.NAME) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Object> NAME = new Tree<>("NAME");
            NAME.setValue(null);
            lex.nextToken();
            Tree<Object> result = new Tree<>("t", NAME);
            result.setValue(null);
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    public Tree<Object> parse(InputStream is) throws ParseException {
        lex = new Lab2LexicalAnalyzer(is);
        lex.nextToken();
        return start();
    }



}
