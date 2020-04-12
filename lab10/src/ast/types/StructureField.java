package ast.types;

import ast.ASTNode;
import visitors.Visitor;

public class StructureField implements ASTNode {
    private int line;
    private int column;
    private String name;
    private Type type;

    public StructureField(int line, int column, String name, Type type) {
        this.line=line;
        this.column=column;
        this.name = name;
        this.type = type;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }



    @Override
    public String toString() {
        return "StructureField{" +
                "line=" + line +
                ", column=" + column +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
