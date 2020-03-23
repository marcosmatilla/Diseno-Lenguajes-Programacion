package ast.types;

import errorhandler.ErrorHandler;
import ast.visitors.Visitor;

public class ErrorType extends AbstractType {
    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getEH().AddError(this);
    }

    @Override
    public String toString() {
        return "ErrorType{" + "line=" + getLine() + " column=" + getColumn() +
                " message='" + message + '\'' +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
