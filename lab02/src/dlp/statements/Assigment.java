package dlp.statements;

import dlp.expresions.Expresion;

public class Assigment extends AbstractStatement {
    private Expresion expresion1;
    private Expresion expresion2;

    public Assigment(int line, int column, Expresion expresion1, Expresion expresion2) {
        super(line, column);
        this.expresion1 = expresion1;
        this.expresion2 = expresion2;
    }
}
