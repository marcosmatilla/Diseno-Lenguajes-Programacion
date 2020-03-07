package ast.expresions;

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

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public String toString() {
        return "AbstractExpresion{" +
                "line=" + line +
                ", column=" + column +
                '}';
    }
}
