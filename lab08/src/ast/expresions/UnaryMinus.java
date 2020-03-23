package ast.expresions;

import visitors.Visitor;

public class UnaryMinus extends AbstractExpresion {
    private Expresion expresion;

    public UnaryMinus(int line, int column, Expresion expresion) {
        super(line, column);
        this.expresion = expresion;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    @Override
    public String toString() {
        return "UnaryMinus{" +
                "expresion=" + expresion +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
