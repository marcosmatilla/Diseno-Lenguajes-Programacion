package ast.expresions;

public class Variable extends AbstractExpresion {
    private InvokeFunction invokeFunction;

    public Variable(int line, int column, InvokeFunction invokeFunction) {
        super(line, column);
        this.invokeFunction = invokeFunction;
    }
}
