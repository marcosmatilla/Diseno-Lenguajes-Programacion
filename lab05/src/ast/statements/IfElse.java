package ast.statements;

import ast.expresions.Expresion;

import java.util.ArrayList;

public class IfElse extends AbstractStatement {
    private Expresion expresion;
    private ArrayList<Statement> ifs;
    private ArrayList<Statement> elses;

    public IfElse(int line, int column, Expresion expresion, ArrayList<Statement> ifs, ArrayList<Statement> elses) {
        super(line, column);
        this.expresion = expresion;
        this.ifs = ifs;
        this.elses = elses;
    }
}
