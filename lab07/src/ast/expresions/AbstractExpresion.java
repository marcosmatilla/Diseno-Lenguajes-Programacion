package ast.expresions;

        import ast.AbstractASTNode;

public abstract class AbstractExpresion extends AbstractASTNode implements Expresion {
    private boolean lValue;

    public AbstractExpresion(int line, int column) {
        super(line, column);
    }


    @Override
    public void setLValue(boolean is) {
        this.lValue=is;
    }

    @Override
    public boolean getLValue() {
        return lValue;
    }
}
