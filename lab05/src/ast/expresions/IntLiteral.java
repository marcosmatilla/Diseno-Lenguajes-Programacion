package ast.expresions;

public class IntLiteral extends AbstractExpresion {
    private int value;
    public IntLiteral(int line, int column, int value) {
        super(line, column);
        this.value=value;
    }

    @Override
    public String toString() {
        return "IntLiteral{" +
                "value=" + value +
                '}';
    }
}
