package ast.statements;

import ast.expresions.Expresion;

public class Input extends AbstractStatement {
    private Expresion expresion;

    public Input(int line, int column, Expresion expresion) {
        super(line, column);
        this.expresion = expresion;
    }
}
