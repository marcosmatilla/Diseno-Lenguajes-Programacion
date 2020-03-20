package dlp.statements;

import dlp.expresions.Expresion;

public class Return extends AbstractStatement {
    private Expresion expresion;

    public Return(int line, int column, Expresion expresion) {
        super(line, column);
        this.expresion = expresion;
    }
}
