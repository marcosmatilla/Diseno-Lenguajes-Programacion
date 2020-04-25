package visitors.codegenerator;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.statements.Assigment;
import ast.statements.Input;
import ast.statements.Print;
import ast.statements.Statement;
import ast.types.FunctionType;
import ast.types.VoidType;
import codegenerator.CodeGenerator;

import java.io.FileWriter;
import java.io.IOException;

public class ExecuteCGVisitor extends AbstractCGVisitor {
    private String inputFileName;
    private String outputFileName;
    private FileWriter fileWriter;

    private CodeGenerator cg;
    private ValueCGVisitor valueCGVisitor;
    private AddressCGVisitor addressCGVisitor;

    public ExecuteCGVisitor(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;

        try {
            fileWriter = new FileWriter(outputFileName);
        } catch (IOException io) {
            System.err.println("The output file " + outputFileName + " cant be open.");
            return;
        }

        cg = new CodeGenerator(fileWriter);

        valueCGVisitor = new ValueCGVisitor(cg);
        addressCGVisitor = new AddressCGVisitor(cg);

        valueCGVisitor.setAddressCGVisitor(addressCGVisitor);
        addressCGVisitor.setValueCGVisitor(valueCGVisitor);
    }


    private void closeWriter() {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("Error closing the output file: " + outputFileName);
            }
        }
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
        cg.principalDirective(inputFileName);

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

        closeWriter();

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
        cg.name(functionDefinition.getName());

        int numberOfBytesLocal = 0;
        int numberOfBytesParam = 0;

        cg.comment("Parametros");
        for (VariableDefinition v : functionType.getVariableDefinitions()) {
            numberOfBytesParam += v.getType().numberOfBytes();
        }

        cg.comment("Variables Locales");
        for (Statement st : functionDefinition.getStatements()) {
            if (st instanceof VariableDefinition) {
                numberOfBytesLocal += ((VariableDefinition) st).getType().numberOfBytes();
                st.accept(this, param);
            }
        }

        cg.enter(numberOfBytesLocal);

        for (Statement st : functionDefinition.getStatements()) {
            if(!(st instanceof VariableDefinition))
                st.accept(this, param);
        }

        if (functionType.getReturnType() instanceof VoidType) {
            cg.ret(0, numberOfBytesLocal, numberOfBytesParam);
        }

        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object param) {
        /*
         *  execute[[VariableDefinition: varDef -> type ID]](scope) =
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

        cg.convert(assigment.getExpresion2().getType(), assigment.getExpresion1().getType());
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


}
