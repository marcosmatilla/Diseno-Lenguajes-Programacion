package ast.statements;

import ast.expresions.Expresion;

import java.util.ArrayList;

public class While extends AbstractStatement {
    private Expresion expresion;
    private ArrayList<Statement> statements;

    public While(int line, int column, Expresion expresion, ArrayList<Statement> statements) {
        super(line, column);
        this.expresion = expresion;
        this.statements = statements;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    public ArrayList<Statement> getStatements() {
        return statements;
    }

    public void setStatements(ArrayList<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "While{" +
                "expresion=" + expresion +
                ", statements=" + statements +
                '}';
    }
}
