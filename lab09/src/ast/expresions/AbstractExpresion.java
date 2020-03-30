package ast.expresions;

        import ast.AbstractASTNode;
        import ast.types.Type;

public abstract class AbstractExpresion extends AbstractASTNode implements Expresion {
    private boolean lValue;
    private Type type;

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

    @Override
    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Type getType() {
        return type;
    }
}
