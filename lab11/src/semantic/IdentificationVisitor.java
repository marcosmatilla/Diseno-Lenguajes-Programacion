package semantic;

import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expresions.Variable;
import ast.statements.Statement;
import ast.types.ErrorType;
import symboltable.SymbolTable;
import visitors.AbstratVisitor;

public class IdentificationVisitor extends AbstratVisitor {
    SymbolTable st;

    public IdentificationVisitor(){
        this.st = new SymbolTable();
    }

    @Override
    public Object visit(Variable variable, Object param) {
        variable.definition = st.find(variable.getName());
        if(variable.definition == null){
            variable.definition = new VariableDefinition(variable.getLine(), variable.getColumn(), variable.getName(), new ErrorType(variable,"Semantical error: " + variable.getName() + " has not been declared"));
        }
        return null;
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object param) {
        if(!st.insert(functionDefinition)){
            new ErrorType(functionDefinition,"Semantical error: " + functionDefinition.getName() + " identificator already defined in this scope");
        }
        else{
            st.set();
            functionDefinition.getType().accept(this, param);
            for(Statement s: functionDefinition.getStatements()){
                s.accept(this, null);
            }
            st.reset();
        }
        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object param) {
        if(!st.insert(variableDefinition)){
            new ErrorType(variableDefinition,  "Semantical error: " + "'" + variableDefinition.getName() + "'" + " identificator already declared");
        }
        return null;
    }
}
