package ast.expresions;

import ast.ASTNode;
import ast.types.Type;

public interface Expresion extends ASTNode {

    void setLValue(boolean is);
    boolean getLValue();
    void setType(Type type);
    Type getType();
}
