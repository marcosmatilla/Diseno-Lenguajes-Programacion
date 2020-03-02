package ast.expresions;

public class Logic extends AbstractExpresion {
    private Expresion expresion1;
    private Expresion expresion2;

    public Logic(int line, int column, Expresion expresion1, Expresion expresion2) {
        super(line, column);
        this.expresion1 = expresion1;
        this.expresion2 = expresion2;
    }
}
