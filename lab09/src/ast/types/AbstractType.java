package ast.types;

import ast.AbstractASTNode;

public abstract class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean isLogical() {
        return false;
    }

    @Override
    public Type arithmetic(Type type) {
        return null;
    }
}
