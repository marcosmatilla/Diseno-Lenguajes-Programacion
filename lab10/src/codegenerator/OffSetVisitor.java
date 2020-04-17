package codegenerator;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.types.FunctionType;
import ast.types.StructureField;
import ast.types.StructureType;
import visitors.AbstratVisitor;

public class OffSetVisitor extends AbstratVisitor {

    int globalOffset;
    int localOffset;

    @Override
    public Object visit(VariableDefinition variableDefinition, Object param) {
        if(variableDefinition.getScope() == 0){
            variableDefinition.setOffset(globalOffset);
            globalOffset += variableDefinition.getType().numberOfBytes();
        }
        else{
            localOffset-=variableDefinition.getType().numberOfBytes();
            variableDefinition.setOffset(localOffset);
        }
        super.visit(variableDefinition, param);
        return null;
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object param) {
        localOffset = 0;
        return super.visit(functionDefinition, param);
    }

    @Override
    public Object visit(FunctionType functionType, Object param) {
       localOffset = 4;
       functionType.getReturnType().accept(this, null);
       for(int i = functionType.getVariableDefinitions().size() -1; i >= 0; i--){
           functionType.getVariableDefinitions().get(i).setOffset(localOffset);
           localOffset += functionType.getVariableDefinitions().get(i).getType().numberOfBytes();
       }
       localOffset = 0;
       return null;
    }

    @Override
    public Object visit(StructureType structureType, Object param) {
        int offset = 0;
        for(StructureField r : structureType.getStructureFields()){
            r.accept(this,param);
            r.setOffset(offset);
            offset += r.getType().numberOfBytes();
        }
        return null;
    }

}
