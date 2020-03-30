package ast.types;

import visitors.Visitor;

public class VoidType extends AbstractType {
    public VoidType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "VoidType{}";
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
