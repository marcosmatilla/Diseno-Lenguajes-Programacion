package ast.expresions;

public class UnaryMinus extends AbstractExpresion {
    private Expresion expresion;

    public UnaryMinus(int line, int column, Expresion expresion) {
        super(line, column);
        this.expresion = expresion;
    }
}
