package ast.types;

import ast.VariableDefinition;

public class ArrayType extends AbstractType {
    private Type type;
    private VariableDefinition variableDefinition;

    public ArrayType(int line, int column, Type type, VariableDefinition variableDefinition) {
        super(line, column);
        this.type = type;
        this.variableDefinition = variableDefinition;
    }
}
