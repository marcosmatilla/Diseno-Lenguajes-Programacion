package ast.expresions;

public class IntLiteral extends AbstractExpresion {
    public IntLiteral(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "IntLiteral{}";
    }
}
