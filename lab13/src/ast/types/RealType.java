package ast.types;

import visitors.Visitor;

public class RealType extends AbstractType {

    public RealType() {
        super(0, 0);
    }

    public RealType(int line, int column) {
        super(line, column);
    }

    private static RealType instance = new RealType();

    public static RealType getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "double";
    }

    @Override
    public Type arithmetic(Type type) {
        if (type instanceof ErrorType ||
                type instanceof RealType)
            return type;

        if (type instanceof IntType ||
                type instanceof CharType)
            return this;
        return null;
    }

    @Override
    public Type promotesTo(Type type) {
        if (type instanceof ErrorType || type.isBuiltInType())
            return type;
        return null;
    }

    @Override
    public Type comparasion(Type type) {
        if (type instanceof RealType)
            return IntType.getInstance();
        return null;
    }

    @Override
    public boolean isBuiltInType() {
        return true;
    }

    @Override
    public Type canBeCastTo(Type type) {
        if (type.isBuiltInType() || type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public int numberOfBytes() {
        return 4;
    }

    @Override
    public char suffix() {
        return 'f';
    }

    @Override
    public Type arithmetic() {
        return this;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public Type assignWith(Type type) {
        if(type instanceof RealType){
            return this;
        } else if(type instanceof ErrorType){
            return type;
        }
        return null;
    }
}
