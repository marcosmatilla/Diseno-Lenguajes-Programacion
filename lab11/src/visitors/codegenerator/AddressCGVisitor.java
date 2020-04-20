package visitors.codegenerator;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;
import visitors.Visitor;

public class AddressCGVisitor extends AbstractCGVisitor{
    @Override
    public Object visit(Variable variable, Object param) {
        /*
        * address[[Variable: expression -> ID]]() =
        *   if(expression.definition.scope == 0)
        *       <pusha> expression.definition.offset
        *   else
        *       <push bp>
        *       <pushi> expression.definition.offset
        *       <addi>
        */
        return super.visit(variable, param);
    }
}
