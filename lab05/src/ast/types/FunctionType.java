package ast.types;

import ast.VariableDefinition;

public class FunctionType extends AbstractType {
    private VariableDefinition vd;
    public FunctionType(int line, int column, VariableDefinition vd) {
        super(line, column);
        this.vd = vd;
    }
}
