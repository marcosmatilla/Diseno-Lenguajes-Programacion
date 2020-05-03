package codegenerator;

import ast.definitions.VariableDefinition;
import ast.types.Type;

import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {
    protected FileWriter fileWriter;
    public String inputFileName;
    public String outputFileName;

    int cont;

    public CodeGenerator(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;

        try {
            fileWriter = new FileWriter(outputFileName);
        } catch (IOException io) {
            System.err.println("The output file " + outputFileName + " cant be open");
        }
    }

    public void closeWriter() {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("Error closing the output file " + outputFileName);
            }
        }
    }

    private void println_tab(String str) {
        println("\t" + str);
    }

    private void println(String str) {
        try {
            fileWriter.write(str + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLabel() {
        cont++;
        return cont;
    }

    public void enter(int numberOfBytesLocal) {
        println_tab("enter " + numberOfBytesLocal);
    }

    public void add(Type type) {
        println_tab("add" + type.suffix());
    }

    public void mul(Type type) {
        println_tab("mul" + type.suffix());
    }

    public void subtract(Type type) {
        println_tab("sub" + type.suffix());
    }

    public void div(Type type) {
        println_tab("div" + type.suffix());
    }

    public void mod(Type type) {
        println_tab("mod" + type.suffix());
    }

    public void pusha(int offset) {
        println_tab("pusha " + offset);
    }

    public void pushbp() {
        println_tab("push bp");
    }

    public void push(char value) {
        println_tab("pushb " + (int) value);
    }

    public void push(int value) {
        println_tab("pushi " + value);
    }

    public void push(double value) {
        println_tab("pushf " + value);
    }

    public void pop(Type type) {
        println_tab("pop" + type.suffix());
    }

    public void not() {
        println_tab("not");
    }

    public void and() {
        println_tab("and");
    }

    public void or() {
        println_tab("or");
    }

    public void dup(Type type) {
        println_tab("dup" + type.suffix());
    }

    public void ret(int numerOfBytesReturnType, int numberOfBytesLocal, int numberOfBytesParam) {
        println_tab("ret\t" + numerOfBytesReturnType + ", " + numberOfBytesLocal + ", " + numberOfBytesParam);
    }

    public void varDefinitionComment(VariableDefinition variableDefinition) {
        String type = variableDefinition.getType().toString();
        String name = variableDefinition.getName();
        int offset = variableDefinition.getOffset();
        comment(type + " " + name + " (offset " + offset + ")");
    }

    public void load(Type type) {
        println_tab("load" + type.suffix());
    }

    public void store(Type type) {
        println_tab("store" + type.suffix());
    }

    public void in(Type type) {
        println_tab("in" + type.suffix());
    }

    public void out(Type type) {
        println_tab("out" + type.suffix());
    }

    public void callMain() {
        println("\n' Invocation to the main function");
        println("call main");
    }

    public void call(String name) {
        println_tab("call " + name);
    }

    public void halt() {
        println("halt");
    }

    public void convert(Type type1, Type type2) {
        char t1 = type1.suffix();
        char t2 = type2.suffix();

        switch (t1) {
            case 'b':
                if (t2 == 'i') {
                    b2i();
                } else if (t2 == 'f') {
                    b2i();
                    i2f();
                }
                break;
            case 'i':
                if (t2 == 'b') {
                    i2b();
                } else if (t2 == 'f') i2f();
                break;
            case 'f':
                if (t2 == 'i') {
                    f2i();
                } else if (t2 == 'b') {
                    f2i();
                    i2b();
                }
                break;
        }
    }

    public void b2i() {
        println_tab("b2i");
    }

    public void i2b() {
        println_tab("i2b");
    }

    public void i2f() {
        println_tab("i2f");
    }

    public void f2i() {
        println_tab("f2i");
    }

    public void arithmetic(Type type, String operator) {
        switch (operator) {
            case "+":
                add(type);
                break;
            case "-":
                subtract(type);
                break;
            case "*":
                mul(type);
                break;
            case "/":
                div(type);
                break;
            case "%":
                mod(type);
                break;
        }
    }

    public void comparasion(Type type, String operator) {
        switch (operator) {
            case ">":
                println_tab("gt" + type.suffix());
                break;
            case "<":
                println_tab("lt" + type.suffix());
                break;
            case ">=":
                println_tab("ge" + type.suffix());
                break;
            case "<=":
                println_tab("le" + type.suffix());
                break;
            case "==":
                println_tab("eq" + type.suffix());
                break;
            case "!=":
                println_tab("ne" + type.suffix());
                break;
        }

    }


    public void logical(String operator) {
        switch (operator) {
            case "&&":
                and();
                break;
            case "||":
                or();
                break;
        }

    }

    public void jmp(String jump) {
        println_tab("jmp " + jump);
    }

    public void jz(String jump) {
        println_tab("jz " + jump);
    }

    public void jnz(String jump) {
        println_tab("jnz " + jump);
    }

    public void label(String name) {
        println("\n " + name + ":");
    }

    public void principalDirective(String inputFileName) {
        println("\n#source " + "\"" + inputFileName + "\"" + "\n");
    }

    public void lineDirective(int line) {
        println("\n#line " + line);
    }

    public void comment(String str) {
        println_tab("' * " + str);
    }


    public void arth(Type type, String operador) {
        switch (operador) {
            case "++":
                add(type);
                break;
            case "--":
                subtract(type);
                break;
        }
    }


}
