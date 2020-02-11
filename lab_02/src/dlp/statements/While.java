package dlp.statements;

import dlp.expresions.Expresion;

import java.util.ArrayList;

public class While extends AbstractStatement {
    private Expresion expresion;
    private ArrayList<Statement> whiles;

    public While(int line, int column, Expresion expresion, ArrayList<Statement> whiles) {
        super(line, column);
        this.expresion = expresion;
        this.whiles = whiles;
    }
}
