package ast.types;

import ast.errorhandler.ErrorHandler;

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
}
