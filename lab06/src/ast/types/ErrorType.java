package ast.types;

public class ErrorType extends AbstractType {
    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
    }

    @Override
    public String toString() {
        return "ErrorType{" +
                "message='" + message + '\'' +
                '}';
    }
}
