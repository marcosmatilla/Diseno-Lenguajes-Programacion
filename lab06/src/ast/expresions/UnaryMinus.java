package ast.expresions;

public class UnaryMinus extends AbstractExpresion {
    private Expresion expresion;

    public UnaryMinus(int line, int column, Expresion expresion) {
        super(line, column);
        this.expresion = expresion;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    @Override
    public String toString() {
        return "UnaryMinus{" +
                "expresion=" + expresion +
                '}';
    }
}
