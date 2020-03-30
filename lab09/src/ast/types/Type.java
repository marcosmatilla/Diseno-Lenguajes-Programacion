package ast.types;

import ast.ASTNode;

public interface Type extends ASTNode {
    boolean isLogical();
    Type arithmetic(Type type);
}
