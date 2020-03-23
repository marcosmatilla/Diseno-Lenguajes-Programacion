package ast.expresions;

import ast.visitors.Visitor;

public class Variable extends AbstractExpresion {
    private String name;
    public Variable(int line, int column, String name) {
        super(line, column);
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
