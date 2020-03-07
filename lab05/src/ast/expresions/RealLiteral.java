package ast.expresions;

public class RealLiteral extends AbstractExpresion {
    private double value;
    public RealLiteral(int line, int column, double value) {
        super(line, column);
        this.value=value;
    }

    @Override
    public String toString() {
        return "RealLiteral{" +
                "value=" + value +
                '}';
    }
}
