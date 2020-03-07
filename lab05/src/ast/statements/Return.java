package ast.statements;

import ast.expresions.Expresion;

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
}
