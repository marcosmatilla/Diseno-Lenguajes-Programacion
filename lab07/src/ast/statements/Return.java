package ast.statements;

import ast.expresions.Expresion;
import ast.visitors.Visitor;

public class Return extends AbstractStatement {
    private Expresion expresion;

    public Return(int line, int column, Expresion expresion) {
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
        return "Return{" +
                "expresion=" + expresion +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
