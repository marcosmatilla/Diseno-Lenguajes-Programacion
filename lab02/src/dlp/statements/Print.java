package dlp.statements;

import dlp.expresions.Expresion;

public class Print extends AbstractStatement {
    private Expresion expresion;

    public Print(int line, int column, Expresion expresion) {
        super(line, column);
        this.expresion = expresion;
    }
}
