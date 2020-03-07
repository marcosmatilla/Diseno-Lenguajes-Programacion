package ast.expresions;

import ast.types.Type;

public class Cast extends AbstractExpresion {
    private Expresion expresion;
    private Type type;

    public Cast(int line, int column, Expresion expresion, Type type) {
        super(line, column);
        this.expresion = expresion;
        this.type = type;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "expresion=" + expresion +
                ", type=" + type +
                '}';
    }
}
