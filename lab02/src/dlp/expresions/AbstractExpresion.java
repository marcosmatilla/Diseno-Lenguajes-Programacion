package dlp.expresions;

import dlp.statements.AbstractStatement;

public abstract class AbstractExpresion implements Expresion {
    private int line;
    private int column;

    public AbstractExpresion(int line, int column){
        this.line = line;
        this.column = column;
    }
    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }
}
