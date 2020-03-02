package ast.expresions;

public class Negation extends AbstractExpresion {
    private Expresion expresion;

    public Negation(int line, int column, Expresion expresion) {
        super(line, column);
        this.expresion = expresion;
    }
}
