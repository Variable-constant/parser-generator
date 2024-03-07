package parser.lab3;

import java.io.InputStream;
import java.text.ParseException;
import java.util.Set;

import parser.utils.Tree;

public class Lab3Parser {

    private Lab3LexicalAnalyzer lex;

    Tree<String> start() throws ParseException {
        if (Set.of(Lab3Token.PRINT, Lab3Token.INV, Lab3Token.FUNC, Lab3Token.VAR, Lab3Token.VAR_DEC, Lab3Token.END, Lab3Token.WHILE, Lab3Token.IF).contains(lex.curToken())) {
            Tree<String> body = body();
            Tree<String> result = new Tree<>("start", body);
            result.setValue(body.getValue());
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> body() throws ParseException {
        if (Set.of(Lab3Token.PRINT, Lab3Token.INV, Lab3Token.FUNC, Lab3Token.VAR, Lab3Token.VAR_DEC, Lab3Token.END, Lab3Token.WHILE, Lab3Token.IF).contains(lex.curToken())) {
            Tree<String> funcs = funcs();
            Tree<String> exec = exec();
            Tree<String> result = new Tree<>("body", funcs, exec);
            result.setValue(funcs.getValue() + "\n\n int main() {\n" + exec.getValue() + "\n}");
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> funcs() throws ParseException {
        if (Set.of(Lab3Token.PRINT, Lab3Token.INV, Lab3Token.VAR, Lab3Token.VAR_DEC, Lab3Token.END, Lab3Token.WHILE, Lab3Token.IF).contains(lex.curToken())) {
            Tree<String> result = new Tree<>("eps");
            result.setValue("");
            return result;
        } else if (Set.of(Lab3Token.FUNC).contains(lex.curToken())) {
            Tree<String> func = func();
            Tree<String> funcs = funcs();
            Tree<String> result = new Tree<>("funcs", func, funcs);
            result.setValue(func.getValue() + "\n\n" + funcs.getValue());
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> func() throws ParseException {
        if (Set.of(Lab3Token.FUNC).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.FUNC) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> FUNC = new Tree<>("FUNC");
            FUNC.setValue(null);
            lex.nextToken();
            Tree<String> func_name = func_name();
            if (lex.curToken() != Lab3Token.OP_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> OP_BR = new Tree<>("OP_BR");
            OP_BR.setValue(null);
            lex.nextToken();
            if (lex.curToken() != Lab3Token.VAR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> VAR = new Tree<>("VAR");
            VAR.setValue(lex.curValue());
            lex.nextToken();
            if (lex.curToken() != Lab3Token.CL_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> CL_BR = new Tree<>("CL_BR");
            CL_BR.setValue(null);
            lex.nextToken();
            if (lex.curToken() != Lab3Token.CURLY_OP_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> CURLY_OP_BR = new Tree<>("CURLY_OP_BR");
            CURLY_OP_BR.setValue(null);
            lex.nextToken();
            Tree<String> exec = exec();
            if (lex.curToken() != Lab3Token.CURLY_CL_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> CURLY_CL_BR = new Tree<>("CURLY_CL_BR");
            CURLY_CL_BR.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("func", FUNC, func_name, OP_BR, VAR, CL_BR, CURLY_OP_BR, exec, CURLY_CL_BR);
            result.setValue("int " + func_name.getValue() + "(" + "int " + VAR.getValue() + "){\n" + exec.getValue() + "\n}");
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> func_name() throws ParseException {
        if (Set.of(Lab3Token.VAR).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.VAR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> VAR = new Tree<>("VAR");
            VAR.setValue(lex.curValue());
            lex.nextToken();
            Tree<String> result = new Tree<>("func_name", VAR);
            result.setValue(VAR.getValue());
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> exec_unit() throws ParseException {
        if (Set.of(Lab3Token.WHILE).contains(lex.curToken())) {
            Tree<String> wh = wh();
            Tree<String> result = new Tree<>("exec_unit", wh);
            result.setValue(wh.getValue());
            return result;
        } else if (Set.of(Lab3Token.IF).contains(lex.curToken())) {
            Tree<String> fi = fi();
            Tree<String> result = new Tree<>("exec_unit", fi);
            result.setValue(fi.getValue());
            return result;
        } else if (Set.of(Lab3Token.VAR).contains(lex.curToken())) {
            Tree<String> assigning = assigning();
            Tree<String> result = new Tree<>("exec_unit", assigning);
            result.setValue(assigning.getValue() + ";");
            return result;
        } else if (Set.of(Lab3Token.VAR_DEC).contains(lex.curToken())) {
            Tree<String> declaration = declaration();
            Tree<String> result = new Tree<>("exec_unit", declaration);
            result.setValue(declaration.getValue() + ";");
            return result;
        } else if (Set.of(Lab3Token.PRINT).contains(lex.curToken())) {
            Tree<String> print = print();
            Tree<String> result = new Tree<>("exec_unit", print);
            result.setValue(print.getValue() + ";");
            return result;
        } else if (Set.of(Lab3Token.INV).contains(lex.curToken())) {
            Tree<String> func_inv = func_inv();
            Tree<String> result = new Tree<>("exec_unit", func_inv);
            result.setValue(func_inv.getValue() + ";");
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> exec() throws ParseException {
        if (Set.of(Lab3Token.CURLY_CL_BR, Lab3Token.END).contains(lex.curToken())) {
            Tree<String> result = new Tree<>("eps");
            result.setValue("");
            return result;
        } else if (Set.of(Lab3Token.PRINT, Lab3Token.INV, Lab3Token.VAR, Lab3Token.VAR_DEC, Lab3Token.WHILE, Lab3Token.IF).contains(lex.curToken())) {
            Tree<String> exec_unit = exec_unit();
            Tree<String> result = new Tree<>("exec", exec_unit);
            result.setValue(exec_unit.getValue());
            return result;
        } else if (Set.of(Lab3Token.PRINT, Lab3Token.INV, Lab3Token.VAR, Lab3Token.VAR_DEC, Lab3Token.WHILE, Lab3Token.IF).contains(lex.curToken())) {
            Tree<String> exec_unit = exec_unit();
            Tree<String> exec = exec();
            Tree<String> result = new Tree<>("exec", exec_unit, exec);
            result.setValue(exec_unit.getValue() + "\n" + exec.getValue());
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> wh() throws ParseException {
        if (Set.of(Lab3Token.WHILE).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.WHILE) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> WHILE = new Tree<>("WHILE");
            WHILE.setValue(null);
            lex.nextToken();
            Tree<String> expr = expr();
            if (lex.curToken() != Lab3Token.CURLY_OP_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> CURLY_OP_BR = new Tree<>("CURLY_OP_BR");
            CURLY_OP_BR.setValue(null);
            lex.nextToken();
            Tree<String> exec = exec();
            if (lex.curToken() != Lab3Token.CURLY_CL_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> CURLY_CL_BR = new Tree<>("CURLY_CL_BR");
            CURLY_CL_BR.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("wh", WHILE, expr, CURLY_OP_BR, exec, CURLY_CL_BR);
            result.setValue("while " + expr + "{\n" + exec.getValue() + "\n}");
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> fi() throws ParseException {
        if (Set.of(Lab3Token.IF).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.IF) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> IF = new Tree<>("IF");
            IF.setValue(null);
            lex.nextToken();
            if (lex.curToken() != Lab3Token.CURLY_OP_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> CURLY_OP_BR = new Tree<>("CURLY_OP_BR");
            CURLY_OP_BR.setValue(null);
            lex.nextToken();
            Tree<String> exec = exec();
            if (lex.curToken() != Lab3Token.CURLY_CL_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> CURLY_CL_BR = new Tree<>("CURLY_CL_BR");
            CURLY_CL_BR.setValue(null);
            lex.nextToken();
            Tree<String> else_block = else_block();
            Tree<String> result = new Tree<>("fi", IF, CURLY_OP_BR, exec, CURLY_CL_BR, else_block);
            result.setValue("if{\n" + exec.getValue() + "\n}" + else_block.getValue());
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> else_block() throws ParseException {
        if (Set.of(Lab3Token.PRINT, Lab3Token.INV, Lab3Token.VAR, Lab3Token.VAR_DEC, Lab3Token.CURLY_CL_BR, Lab3Token.END, Lab3Token.WHILE, Lab3Token.IF).contains(lex.curToken())) {
            Tree<String> result = new Tree<>("eps");
            result.setValue("");
            return result;
        } else if (Set.of(Lab3Token.ELSE).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.ELSE) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> ELSE = new Tree<>("ELSE");
            ELSE.setValue(null);
            lex.nextToken();
            if (lex.curToken() != Lab3Token.CURLY_OP_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> CURLY_OP_BR = new Tree<>("CURLY_OP_BR");
            CURLY_OP_BR.setValue(null);
            lex.nextToken();
            Tree<String> exec = exec();
            if (lex.curToken() != Lab3Token.CURLY_CL_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> CURLY_CL_BR = new Tree<>("CURLY_CL_BR");
            CURLY_CL_BR.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("else_block", ELSE, CURLY_OP_BR, exec, CURLY_CL_BR);
            result.setValue("else{\n" + exec.getValue() + "\n}");
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> assigning() throws ParseException {
        if (Set.of(Lab3Token.VAR).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.VAR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> VAR = new Tree<>("VAR");
            VAR.setValue(lex.curValue());
            lex.nextToken();
            if (lex.curToken() != Lab3Token.ASSIGNMENT) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> ASSIGNMENT = new Tree<>("ASSIGNMENT");
            ASSIGNMENT.setValue(null);
            lex.nextToken();
            Tree<String> expr = expr();
            Tree<String> result = new Tree<>("assigning", VAR, ASSIGNMENT, expr);
            result.setValue(String.format("%s = %s", VAR.getValue(), expr.getValue()));
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> declaration() throws ParseException {
        if (Set.of(Lab3Token.VAR_DEC).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.VAR_DEC) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> VAR_DEC = new Tree<>("VAR_DEC");
            VAR_DEC.setValue(null);
            lex.nextToken();
            if (lex.curToken() != Lab3Token.VAR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> VAR = new Tree<>("VAR");
            VAR.setValue(lex.curValue());
            lex.nextToken();
            if (lex.curToken() != Lab3Token.ASSIGNMENT) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> ASSIGNMENT = new Tree<>("ASSIGNMENT");
            ASSIGNMENT.setValue(null);
            lex.nextToken();
            Tree<String> expr = expr();
            Tree<String> result = new Tree<>("declaration", VAR_DEC, VAR, ASSIGNMENT, expr);
            result.setValue(String.format("int %s = %s", VAR.getValue(), expr.getValue()));
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> print() throws ParseException {
        if (Set.of(Lab3Token.PRINT).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.PRINT) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> PRINT = new Tree<>("PRINT");
            PRINT.setValue(null);
            lex.nextToken();
            Tree<String> expr = expr();
            Tree<String> result = new Tree<>("print", PRINT, expr);
            result.setValue(String.format("printf(\"%%d\\n\", %s)", expr.getValue()));
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> expr() throws ParseException {
        if (Set.of(Lab3Token.INV, Lab3Token.VAR, Lab3Token.NUM).contains(lex.curToken())) {
            Tree<String> value = value();
            Tree<String> r_expr = r_expr();
            Tree<String> result = new Tree<>("expr", value, r_expr);
            result.setValue(String.format("(%s %s)", value.getValue(), r_expr.getValue()));
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> r_expr() throws ParseException {
        if (Set.of(Lab3Token.PRINT, Lab3Token.INV, Lab3Token.CL_BR, Lab3Token.CURLY_OP_BR, Lab3Token.VAR, Lab3Token.VAR_DEC, Lab3Token.CURLY_CL_BR, Lab3Token.END, Lab3Token.WHILE, Lab3Token.IF).contains(lex.curToken())) {
            Tree<String> result = new Tree<>("eps");
            result.setValue("");
            return result;
        } else if (Set.of(Lab3Token.DIV, Lab3Token.ADD, Lab3Token.SUB, Lab3Token.OR, Lab3Token.EQUALS, Lab3Token.MUL, Lab3Token.AND, Lab3Token.GREATER, Lab3Token.LESS, Lab3Token.XOR).contains(lex.curToken())) {
            Tree<String> op = op();
            Tree<String> value = value();
            Tree<String> result = new Tree<>("r_expr", op, value);
            result.setValue(op.getValue() + value.getValue());
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> func_inv() throws ParseException {
        if (Set.of(Lab3Token.INV).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.INV) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> INV = new Tree<>("INV");
            INV.setValue(null);
            lex.nextToken();
            if (lex.curToken() != Lab3Token.VAR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> VAR = new Tree<>("VAR");
            VAR.setValue(lex.curValue());
            lex.nextToken();
            if (lex.curToken() != Lab3Token.OP_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> OP_BR = new Tree<>("OP_BR");
            OP_BR.setValue(null);
            lex.nextToken();
            Tree<String> expr = expr();
            if (lex.curToken() != Lab3Token.CL_BR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> CL_BR = new Tree<>("CL_BR");
            CL_BR.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("func_inv", INV, VAR, OP_BR, expr, CL_BR);
            result.setValue(VAR.getValue() + "(" + expr.getValue() + ")");
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> value() throws ParseException {
        if (Set.of(Lab3Token.NUM).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.NUM) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> NUM = new Tree<>("NUM");
            NUM.setValue(lex.curValue());
            lex.nextToken();
            Tree<String> result = new Tree<>("value", NUM);
            result.setValue(NUM.getValue());
            return result;
        } else if (Set.of(Lab3Token.VAR).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.VAR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> VAR = new Tree<>("VAR");
            VAR.setValue(lex.curValue());
            lex.nextToken();
            Tree<String> result = new Tree<>("value", VAR);
            result.setValue(VAR.getValue());
            return result;
        } else if (Set.of(Lab3Token.INV).contains(lex.curToken())) {
            Tree<String> func_inv = func_inv();
            Tree<String> result = new Tree<>("value", func_inv);
            result.setValue(func_inv.getValue());
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> ret() throws ParseException {
        if (Set.of(Lab3Token.RETURN).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.RETURN) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> RETURN = new Tree<>("RETURN");
            RETURN.setValue(null);
            lex.nextToken();
            Tree<String> expr = expr();
            Tree<String> result = new Tree<>("ret", RETURN, expr);
            result.setValue(expr.getValue());
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    Tree<String> op() throws ParseException {
        if (Set.of(Lab3Token.ADD).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.ADD) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> ADD = new Tree<>("ADD");
            ADD.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("op", ADD);
            result.setValue("+");
            return result;
        } else if (Set.of(Lab3Token.SUB).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.SUB) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> SUB = new Tree<>("SUB");
            SUB.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("op", SUB);
            result.setValue("-");
            return result;
        } else if (Set.of(Lab3Token.MUL).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.MUL) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> MUL = new Tree<>("MUL");
            MUL.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("op", MUL);
            result.setValue("*");
            return result;
        } else if (Set.of(Lab3Token.DIV).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.DIV) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> DIV = new Tree<>("DIV");
            DIV.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("op", DIV);
            result.setValue("/");
            return result;
        } else if (Set.of(Lab3Token.LESS).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.LESS) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> LESS = new Tree<>("LESS");
            LESS.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("op", LESS);
            result.setValue("<");
            return result;
        } else if (Set.of(Lab3Token.GREATER).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.GREATER) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> GREATER = new Tree<>("GREATER");
            GREATER.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("op", GREATER);
            result.setValue(">");
            return result;
        } else if (Set.of(Lab3Token.AND).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.AND) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> AND = new Tree<>("AND");
            AND.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("op", AND);
            result.setValue("&&");
            return result;
        } else if (Set.of(Lab3Token.OR).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.OR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> OR = new Tree<>("OR");
            OR.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("op", OR);
            result.setValue("||");
            return result;
        } else if (Set.of(Lab3Token.XOR).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.XOR) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> XOR = new Tree<>("XOR");
            XOR.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("op", XOR);
            result.setValue("^^");
            return result;
        } else if (Set.of(Lab3Token.EQUALS).contains(lex.curToken())) {
            if (lex.curToken() != Lab3Token.EQUALS) {
                throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
            }
            Tree<String> EQUALS = new Tree<>("EQUALS");
            EQUALS.setValue(null);
            lex.nextToken();
            Tree<String> result = new Tree<>("op", EQUALS);
            result.setValue("==");
            return result;
        }
        throw new ParseException("Expected another token at position " + lex.curPos(), lex.curPos());
    }

    public Tree<String> parse(InputStream is) throws ParseException {
        lex = new Lab3LexicalAnalyzer(is);
        lex.nextToken();
        return start();
    }



}
