package visitors.codegenerator;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expresions.InvokeFunction;
import ast.statements.*;
import ast.types.FunctionType;
import ast.types.IntType;
import ast.types.VoidType;
import codegenerator.CodeGenerator;

import java.util.ArrayList;

public class ExecuteCGVisitor extends AbstractCGVisitor {
    private CodeGenerator cg;

    private ValueCGVisitor valueCGVisitor;
    private AddressCGVisitor addressCGVisitor;

    public ExecuteCGVisitor(String inputFileName, String outputFileName) {
        cg = new CodeGenerator(inputFileName, outputFileName);

        valueCGVisitor = new ValueCGVisitor(cg);
        addressCGVisitor = new AddressCGVisitor(cg);

        valueCGVisitor.setAddressCGVisitor(addressCGVisitor);
        addressCGVisitor.setValueCGVisitor(valueCGVisitor);
    }

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
        cg.principalDirective(cg.inputFileName);

        for (Definition d : program.getDefinitions()) {
            if (d instanceof VariableDefinition) {
                d.accept(this, d.getScope());
            }
        }

        cg.callMain();
        cg.halt();

        for (Definition d : program.getDefinitions()) {
            if (d instanceof FunctionDefinition) {
                d.accept(this, param);
            }
        }

        cg.closeWriter();

        return null;
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object param) {
        /*
         *  execute[[FunctionDefinition: definition -> name type statement*]]() =
         *      <enter> functionDefinition.numberOfBytes()
         *      for(Statement s: statements)
         *          if(s instanceof VariableDefinition)
         *              execute[[s]]
         *      if(returntype instanceof Void)
         *          <ret>
         */
        FunctionType functionType = (FunctionType) functionDefinition.getType();

        cg.lineDirective(functionDefinition.getLine());
        cg.label(functionDefinition.getName());

        int numberOfBytesLocal = 0;
        int numberOfBytesParam = 0;

        int numberOfBytesRet = ((FunctionType)functionDefinition.getType()).getReturnType().numberOfBytes();

        cg.comment("Parametros");
        for (VariableDefinition v : functionType.getVariableDefinitions()) {
            numberOfBytesParam += v.getType().numberOfBytes();
            v.accept(this, param);
        }

        cg.comment("Variables Locales");
        for (Statement st : functionDefinition.getStatements()) {
            if (st instanceof VariableDefinition) {
                numberOfBytesLocal += ((VariableDefinition) st).getType().numberOfBytes();
                st.accept(this, param);
            }
        }


        ArrayList<Integer> pass = new ArrayList<Integer>();
        pass.add(numberOfBytesRet);
        pass.add(numberOfBytesLocal);
        pass.add(numberOfBytesParam);

        cg.enter(numberOfBytesLocal);

        for (Statement st : functionDefinition.getStatements()) {
            if (!(st instanceof VariableDefinition))
                st.accept(this, pass);//aqui
        }

        if (functionType.getReturnType() instanceof VoidType) {
            cg.ret(0, numberOfBytesLocal, numberOfBytesParam);
        }
        return null;
    }

    @Override
    public Object visit(FunctionType functionType, Object param) {
        functionType.getVariableDefinitions().forEach(p -> p.accept(this, null));
        return null;
    }

    @Override
    public Object visit(Return _return, Object param) {
        /*
         * execute[[Return: statement -> statement]]() =
         *      value[[expression]]()
         *      <ret> expression.type.numberOfByte()<,>funcDef.bytesLocalSum<,>funcDef.type.bytesParamsSum
         */
        cg.lineDirective(_return.getLine());
        cg.comment("Return");

        ArrayList passed = (ArrayList)param;

        _return.getExpresion().accept(valueCGVisitor, param);
        cg.ret((int)passed.get(0), (int)passed.get(1), (int)passed.get(2));

        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object param) {
        /*
         *  execute[[VariableDefinition: varDef -> type ID]]() =
         *          ' * type.toString() ID (varDef.offset)
         */
        cg.varDefinitionComment(variableDefinition);

        return null;
    }

    @Override
    public Object visit(Assigment assigment, Object param) {
        /*
         *  execute[[Assigment: statement -> expressionL expressionR]]() =
         *      address[[expressionL]]
         *      value[[expressionR]]
         *      <store> expressionL.type.suffix()
         */
        cg.lineDirective(assigment.getLine());
        cg.comment("Assignment");

        assigment.getExpresion1().accept(addressCGVisitor, param);
        assigment.getExpresion2().accept(valueCGVisitor, param);
        cg.store(assigment.getExpresion1().getType());

        return null;
    }

    @Override
    public Object visit(Input input, Object param) {
        /*
         * execute[[Input: statement -> expression]]() =
         *      address[[expression]]()
         *      <in> expression.type.suffix()
         *      <store> expression.type.suffix()
         */
        cg.lineDirective(input.getExpresion().getLine());
        cg.comment("Read");

        input.getExpresion().accept(addressCGVisitor, param);

        cg.in(input.getExpresion().getType());
        cg.store(input.getExpresion().getType());

        return null;
    }

    @Override
    public Object visit(Print print, Object param) {
        /*
         * execute[[Print: statement -> expression]]() =
         *      value[[expression]]()
         *      <out> expression.type.suffix()
         */
        cg.lineDirective(print.getLine());
        cg.comment("Write");

        print.getExpresion().accept(valueCGVisitor, param);
        cg.out(print.getExpresion().getType());

        return null;
    }

    @Override
    public Object visit(InvokeFunction invokeFunction, Object param) {
        /*
         * execute[[InvokeFunction: statement -> expression expression*]]() =
         *      value[[(Expression)statement]]()
         *      if(!((Expression)statement).type instanceof VoidType))
         *          <pop> expression.type.suffix()
         */

        cg.lineDirective(invokeFunction.getLine());

        invokeFunction.getExpresions().forEach(exp -> exp.accept(valueCGVisitor, param));
        cg.call(invokeFunction.getVariable().getName());
        if (!(((FunctionType) invokeFunction.getVariable().getType()).getReturnType() instanceof VoidType)) {
            cg.pop(((FunctionType) invokeFunction.getVariable().getType()).getReturnType());
        }
        return null;
    }


    @Override
    public Object visit(IfElse ifElse, Object param) {
        /*
         * execute[[IfElse: statement1 -> expression statement2* statement3*]]() =
         *      int labelCondition = cg.getLabel()
         *      value[[expression]]
         *      <jz> <label> labelCondition //jz else
         *
         *      for(Statement st2: statement2*)
         *          execute[[st2]]
         *      <jmp> <label> labelCondition //jump finElse
         *
         *      <label> labelCondition <:> //else
         *      for(Statement st3: statement3*)
         *          execute[[st3]]
         *
         *      <label> labelCondition <:> //finElse
         */
        cg.lineDirective(ifElse.getExpresion().getLine());
        cg.comment("If");

        int labelCondition = cg.getLabel();

        ifElse.getExpresion().accept(valueCGVisitor, param);
        cg.convert(ifElse.getExpresion().getType(), IntType.getInstance());
        cg.jz("else" + labelCondition);

        cg.comment("if body");
        for (Statement st2 : ifElse.getIfs()) {
            st2.accept(this, param);
        }
        cg.jmp("end_else" + labelCondition);


        cg.label("else" + labelCondition);
        cg.comment("else body");
        for (Statement st3 : ifElse.getElses()) {
            st3.accept(this, param);
        }
        cg.label("end_else" + labelCondition);

        return null;
    }

    @Override
    public Object visit(While _while, Object param) {
        /*
         * execute[[While: statement -> expression statement*]]() =
         *      int labelCondition = cg.getLabel();
         *      <label> labelCondition <:>
         *      value[[expression]]()
         *      <jz> <label> labelCondition
         *      for(Statement st: statement*)
         *          execute[[st]]()
         *      <jmp label> labelCondition
         *      <label> labelCondition <:>
         */
        cg.lineDirective(_while.getLine());
        cg.comment("While");

        int labelCondition = cg.getLabel();

        cg.label("while" + labelCondition);
        _while.getExpresion().accept(valueCGVisitor, param);
        cg.convert(_while.getExpresion().getType(), IntType.getInstance());
        cg.jz("while_end" + labelCondition);

        cg.comment("while body");
        for (Statement st : _while.getStatements()) {
            st.accept(this, param);
        }
        cg.jmp("while" + labelCondition);
        cg.label("while_end" + labelCondition);

        return null;
    }
}
