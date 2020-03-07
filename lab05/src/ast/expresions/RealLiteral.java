package ast.expresions;

public class RealLiteral extends AbstractExpresion {
    public RealLiteral(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "RealLiteral{}";
    }
}
