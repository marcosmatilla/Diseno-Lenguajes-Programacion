package ast.types;

import ast.ASTNode;

public interface Type extends ASTNode {
    boolean isLogical();
    Type arithmetic(Type type);

    Type promotesTo(Type type);

    Type dot(String campo);
}
