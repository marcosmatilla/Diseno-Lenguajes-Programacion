package ast.types;

import ast.visitors.Visitor;

public class IntType extends AbstractType {

    public IntType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "IntType{}";
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
