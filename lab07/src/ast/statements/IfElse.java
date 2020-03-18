package ast.statements;

import ast.expresions.Expresion;
import ast.visitors.Visitor;

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

    public IfElse(int line, int column, Expresion expresion, ArrayList<Statement> ifs) {
        super(line, column);
        this.expresion = expresion;
        this.ifs = ifs;
        this.elses=new ArrayList<Statement>();
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    public ArrayList<Statement> getIfs() {
        return ifs;
    }

    public void setIfs(ArrayList<Statement> ifs) {
        this.ifs = ifs;
    }

    public ArrayList<Statement> getElses() {
        return elses;
    }

    public void setElses(ArrayList<Statement> elses) {
        this.elses = elses;
    }

    @Override
    public String toString() {
        return "IfElse{" +
                "expresion=" + expresion +
                ", ifs=" + ifs +
                ", elses=" + elses +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
