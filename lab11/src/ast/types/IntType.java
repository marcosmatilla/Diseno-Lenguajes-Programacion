package ast.types;

import visitors.Visitor;

public class IntType extends AbstractType {

    public IntType() {
        super(0, 0);
    }

    private static IntType instance = new IntType();
    public static IntType getInstance() { return instance; }

    @Override
    public boolean isLogical() {
        return true;
    }

    @Override
    public Type arithmetic(Type type) {
        if(type instanceof IntType || type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public Type promotesTo(Type type) {
        if(type instanceof IntType || type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public Type logic(Type type) {
        if(type instanceof IntType)
            return type;
        return null;
    }

    @Override
    public Type comparasion(Type type) {
        if(type instanceof IntType)
            return type;
        return null;
    }

    @Override
    public Type logic() {
        return IntType.getInstance();
    }

    @Override
    public boolean isBuiltInType() {
        return true;
    }

    @Override
    public Type canBeCastTo(Type type) {
        if(type.isBuiltInType())
            return type;
        return null;
    }

    @Override
    public Type arithmetic() {
        return this;
    }

    @Override
    public int numberOfBytes() {
        return 2;
    }

    @Override
    public String toString() {
        return "int";
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

}
