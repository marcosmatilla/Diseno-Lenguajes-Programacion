package ast.types;

import visitors.Visitor;

public class IntType extends AbstractType {

    public IntType() {
        super(0, 0);
    }

    public IntType(int line, int column) {
        super(line, column);
    }

    private static IntType instance = new IntType();
    public static IntType getInstance() { return instance; }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public boolean isLogical() {
        return true;
    }

    @Override
    public Type arithmetic(Type type) {
        if(type.equals(IntType.getInstance()) || type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public Type promotesTo(Type type) {
        if(type instanceof IntType || type instanceof RealType || type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public Type logic(Type type) {
        if(type instanceof IntType)
            return type;
        return null;
    }
}
