package ast.types;

import ast.definitions.VariableDefinition;
import ast.visitors.Visitor;

import java.util.List;

public class FunctionType extends AbstractType {
    private List<VariableDefinition> variableDefinitions;
    private Type returnType;

    public FunctionType(int line, int column, List<VariableDefinition> variableDefinitions, Type returnType) {
        super(line, column);
        this.variableDefinitions = variableDefinitions;
        this.returnType = returnType;
    }

    public List<VariableDefinition> getVariableDefinitions() {
        return variableDefinitions;
    }

    public void setVariableDefinitions(List<VariableDefinition> variableDefinitions) {
        this.variableDefinitions = variableDefinitions;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    @Override
    public String toString() {
        return "FunctionType{" +
                "variableDefinitions=" + variableDefinitions +
                ", returnType=" + returnType +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
