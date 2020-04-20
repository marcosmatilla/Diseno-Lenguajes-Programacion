package visitors.codegenerator;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.statements.Assigment;
import ast.statements.Input;
import ast.statements.Print;

public class ExecuteCGVisitor extends AbstractCGVisitor{
    @Override
    public Object visit(Program program, Object param) {
        /*
         * execute[[Program: program -> definition*]]() =
         *      for(Definition d: definition*)
         *          if(d instanceof VariableDefinition)
         *              execute[[d]]()
         *
         * <call main>
         * <halt>
         *
         *      for(Definition d: definition*)
         *          if(!(d instanceof VariableDefinition))
         *              execute[[d]]()
         */
        return super.visit(program, param);
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object param) {
        /*
         *
         *
         */
        return super.visit(functionDefinition, param);
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object param) {
        /*
         *
         *
         */
        return super.visit(variableDefinition, param);
    }

    @Override
    public Object visit(Assigment assigment, Object param) {
        /*
         *  execute[[Assigment: statement -> expressionL expressionR]]() =
         *      address[[expressionL]]
         *      value[[expressionR]]
         *      <store> expressionL.type.suffix()
         */
        return super.visit(assigment, param);
    }

    @Override
    public Object visit(Input input, Object param) {
        /*
         * execute[[Input: statement -> expression]]() =
         *      address[[expression]]()
         *      <in> expression.type.suffix()
         *      <store> expression.type.suffix()
         */
        return super.visit(input, param);
    }

    @Override
    public Object visit(Print print, Object param) {
        /*
         * execute[[Print: statement -> expression]]() =
         *      value[[expression]]()
         *      <out> expression.type.suffix()
         */
        return super.visit(print, param);
    }


}
