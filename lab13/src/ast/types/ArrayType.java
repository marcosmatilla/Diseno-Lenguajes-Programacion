package ast.types;

import visitors.Visitor;

public class ArrayType extends AbstractType {
    private Type type;
    private int size;

    public ArrayType(int line, int column, Type type, int size) {
        super(line, column);
        this.type = type;
        this.size=size;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Type squareBrackets(Type type) {
        if(type instanceof IntType || type instanceof CharType){
            return this.getType();
        }
        if (type instanceof ErrorType){
            return type;
        }
        return null;
    }

    @Override
    public int numberOfBytes() {
        return size * type.numberOfBytes();
    }

    @Override
    public String toString() {
        return "ArrayType{" +
                "type=" + type +
                ", size=" + size +
                '}';
    }

    @Override
    public char suffix() {
        return type.suffix();
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
