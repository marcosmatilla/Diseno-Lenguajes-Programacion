package ast.types;

import visitors.Visitor;

public class CharType extends AbstractType {
    public CharType() {
        super(0, 0);
    }

    public CharType(int line, int column) {
        super(line, column);
    }

    private static CharType instance = new CharType();
    public static CharType getInstance() { return instance; }



    @Override
    public Type arithmetic(Type type) {
        if(type.equals(CharType.getInstance()) || type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public Type promotesTo(Type type) {
        if(type instanceof CharType || type instanceof ErrorType)
            return type;
        return null;
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
    public int numberOfBytes() {
        return 1;
    }

    @Override
    public String toString() {
        return "char";
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}

