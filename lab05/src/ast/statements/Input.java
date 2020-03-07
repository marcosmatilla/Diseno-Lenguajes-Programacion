package ast.statements;

import ast.expresions.Expresion;

public class Input extends AbstractStatement {
    private Expresion expresion;

    public Input(int line, int column, Expresion expresion) {
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
        return "Input{" +
                "expresion=" + expresion +
                '}';
    }
}
