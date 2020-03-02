package ast.expresions;

public class Comparation extends AbstractExpresion {
    private Expresion expresion1;
    private Expresion expresion2;
    private String operador;

    public Comparation(int line, int column, Expresion expresion1, Expresion expresion2, String operador) {
        super(line, column);
        this.expresion1 = expresion1;
        this.expresion2 = expresion2;
        this.operador = operador;
    }
}
