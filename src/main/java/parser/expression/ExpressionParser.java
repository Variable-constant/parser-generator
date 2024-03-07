package parser.expression;
import java.util.function.Function;

import java.io.InputStream;
import java.text.ParseException;
import java.util.Set;

import parser.utils.Tree;

public class ExpressionParser {

    private ExpressionLexicalAnalyzer lex;

    Tree<Function<Double, Double>> start() throws ParseException {
        if (Set.of(ExpressionToken.NUMBER).contains(lex.curToken())) {
            Tree<Function<Double, Double>> t = t();
            Tree<Function<Double, Double>> ee = ee();
            Tree<Function<Double, Double>> result = new Tree<>("start", t, ee);
            result.setValue(a -> ee.getValue().apply(t.getValue().apply(0D)));
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<Function<Double, Double>> ee() throws ParseException {
        if (Set.of(ExpressionToken.END).contains(lex.curToken())) {
            Tree<Function<Double, Double>> result = new Tree<>("eps");
            result.setValue(a -> a);
            return result;
        } else if (Set.of(ExpressionToken.ADD).contains(lex.curToken())) {
            if (lex.curToken() != ExpressionToken.ADD) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Function<Double, Double>> ADD = new Tree<>("ADD");
            ADD.setValue(null);
            lex.nextToken();
            Tree<Function<Double, Double>> t = t();
            Tree<Function<Double, Double>> ee = ee();
            Tree<Function<Double, Double>> result = new Tree<>("ee", ADD, t, ee);
            result.setValue(a -> ee.getValue().apply(a + t.getValue().apply(0D)));
            return result;
        } else if (Set.of(ExpressionToken.SUB).contains(lex.curToken())) {
            if (lex.curToken() != ExpressionToken.SUB) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Function<Double, Double>> SUB = new Tree<>("SUB");
            SUB.setValue(null);
            lex.nextToken();
            Tree<Function<Double, Double>> t = t();
            Tree<Function<Double, Double>> ee = ee();
            Tree<Function<Double, Double>> result = new Tree<>("ee", SUB, t, ee);
            result.setValue(a -> a - ee.getValue().apply(t.getValue().apply(0D)));
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<Function<Double, Double>> t() throws ParseException {
        if (Set.of(ExpressionToken.NUMBER).contains(lex.curToken())) {
            Tree<Function<Double, Double>> r = r();
            Tree<Function<Double, Double>> tt = tt();
            Tree<Function<Double, Double>> result = new Tree<>("t", r, tt);
            result.setValue(a -> tt.getValue().apply(r.getValue().apply(0D)));
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<Function<Double, Double>> tt() throws ParseException {
        if (Set.of(ExpressionToken.ADD, ExpressionToken.SUB, ExpressionToken.END).contains(lex.curToken())) {
            Tree<Function<Double, Double>> result = new Tree<>("eps");
            result.setValue(a -> a);
            return result;
        } else if (Set.of(ExpressionToken.MUL).contains(lex.curToken())) {
            if (lex.curToken() != ExpressionToken.MUL) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Function<Double, Double>> MUL = new Tree<>("MUL");
            MUL.setValue(null);
            lex.nextToken();
            Tree<Function<Double, Double>> r = r();
            Tree<Function<Double, Double>> tt = tt();
            Tree<Function<Double, Double>> result = new Tree<>("tt", MUL, r, tt);
            result.setValue(a -> tt.getValue().apply(a * r.getValue().apply(1D)));
            return result;
        } else if (Set.of(ExpressionToken.DIV).contains(lex.curToken())) {
            if (lex.curToken() != ExpressionToken.DIV) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Function<Double, Double>> DIV = new Tree<>("DIV");
            DIV.setValue(null);
            lex.nextToken();
            Tree<Function<Double, Double>> r = r();
            Tree<Function<Double, Double>> tt = tt();
            Tree<Function<Double, Double>> result = new Tree<>("tt", DIV, r, tt);
            result.setValue(a -> tt.getValue().apply(a / r.getValue().apply(1D)));
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<Function<Double, Double>> r() throws ParseException {
        if (Set.of(ExpressionToken.NUMBER).contains(lex.curToken())) {
            Tree<Function<Double, Double>> f = f();
            Tree<Function<Double, Double>> rr = rr();
            Tree<Function<Double, Double>> result = new Tree<>("r", f, rr);
            result.setValue(a -> rr.getValue().apply(f.getValue().apply(0D)));
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<Function<Double, Double>> rr() throws ParseException {
        if (Set.of(ExpressionToken.DIV, ExpressionToken.ADD, ExpressionToken.SUB, ExpressionToken.MUL, ExpressionToken.END).contains(lex.curToken())) {
            Tree<Function<Double, Double>> result = new Tree<>("eps");
            result.setValue(a -> a);
            return result;
        } else if (Set.of(ExpressionToken.POW).contains(lex.curToken())) {
            if (lex.curToken() != ExpressionToken.POW) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Function<Double, Double>> POW = new Tree<>("POW");
            POW.setValue(null);
            lex.nextToken();
            Tree<Function<Double, Double>> f = f();
            Tree<Function<Double, Double>> rr = rr();
            Tree<Function<Double, Double>> result = new Tree<>("rr", POW, f, rr);
            result.setValue(a -> Math.pow(a, rr.getValue().apply(f.getValue().apply(0D))));
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<Function<Double, Double>> f() throws ParseException {
        if (Set.of(ExpressionToken.NUMBER).contains(lex.curToken())) {
            if (lex.curToken() != ExpressionToken.NUMBER) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<Function<Double, Double>> NUMBER = new Tree<>("NUMBER");
            NUMBER.setValue(wrapDouble());
            lex.nextToken();
            Tree<Function<Double, Double>> result = new Tree<>("f", NUMBER);
            result.setValue(a -> NUMBER.getValue().apply(0D));
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    public Tree<Function<Double, Double>> parse(InputStream is) throws ParseException {
        lex = new ExpressionLexicalAnalyzer(is);
        lex.nextToken();
        return start();
    }


    private Function<Double, Double> wrapDouble() {
        double val = Double.parseDouble(lex.curValue());
        return a -> val;
    }


}
