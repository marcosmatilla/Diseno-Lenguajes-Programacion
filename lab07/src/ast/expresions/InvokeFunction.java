package ast.expresions;

import ast.statements.Statement;
import ast.visitors.Visitor;

import java.util.ArrayList;

public class InvokeFunction extends AbstractExpresion implements Statement {
    private ArrayList<Expresion> expresions;
    private Variable variable;

    public InvokeFunction(int line, int column, ArrayList<Expresion> expresions, Variable variable) {
        super(line, column);
        this.expresions = expresions;
        this.variable = variable;
    }

    public ArrayList<Expresion> getExpresions() {
        return expresions;
    }

    public void setExpresions(ArrayList<Expresion> expresions) {
        this.expresions = expresions;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    @Override
    public String toString() {
        return "InvokeFunction{" +
                "expresions=" + expresions +
                ", variable=" + variable +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

}
