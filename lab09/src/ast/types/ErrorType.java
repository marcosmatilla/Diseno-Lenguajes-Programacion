package ast.types;

import ast.ASTNode;
import errorhandler.ErrorHandler;
import visitors.Visitor;

public class ErrorType extends AbstractType {
    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getEH().AddError(this);
    }

    public ErrorType(ASTNode node, String message) {
        this(node.getLine(), node.getColumn(), message);
    }

    @Override
    public String toString() {
        return "line=" + getLine() + " column=" + getColumn() +
                " message='" + message + '\'' ;
    }

    @Override
    public Type promotesTo(Type type) {
        return this;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
