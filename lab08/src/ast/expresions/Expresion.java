package ast.expresions;

import ast.ASTNode;

public interface Expresion extends ASTNode {
    void setLValue(boolean is);
    boolean getLValue();
}
