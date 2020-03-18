package ast.types;

import ast.visitors.Visitor;

public class RealType extends AbstractType {
    public RealType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "RealType{}";
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
