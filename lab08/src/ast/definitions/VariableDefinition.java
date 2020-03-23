package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;
import ast.visitors.Visitor;

public class VariableDefinition extends AbstractDefinition implements Statement {
    private int line;
    private int column;

    public VariableDefinition(int line, int column, String name, Type type) {
        super(line, column, name, type);
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
