package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;

public class VariableDefinition extends AbstractDefinition implements Statement {
    private int line;
    private int column;

    public VariableDefinition(int line, int column, String name, Type type) {
        super(line, column, name, type);
    }

}
