package ast.expresions;

import ast.AbstractASTNode;

public abstract class AbstractExpresion extends AbstractASTNode implements Expresion {

    public AbstractExpresion(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "AbstractExpresion{}";
    }
}
