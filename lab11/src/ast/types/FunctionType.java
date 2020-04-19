package ast.types;

import ast.definitions.VariableDefinition;
import ast.expresions.Expresion;
import visitors.Visitor;

import java.util.ArrayList;
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
    public Type parenthesis(ArrayList<Expresion> expressions) {
        int sizeExpressions =  expressions.size();
        int sizeVariableDefinitions = variableDefinitions.size();
        if(sizeExpressions!=sizeVariableDefinitions){ //Comprobamos que los el numero de parametros que pasamos coincida
            return null;
        }
        for(int i=0; i < expressions.size(); i++) {
            if(expressions.get(i).getType()!=variableDefinitions.get(i).getType()) {
                return null;
            }
        }
        return this;
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
