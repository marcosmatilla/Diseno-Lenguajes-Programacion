package codegenerator;

import ast.definitions.VariableDefinition;
import ast.types.Type;

import java.io.FileWriter;
import java.io.IOException;

public class CodeGenerator {

    public String inputFileName;
    public String outputFileName;
    protected FileWriter fileWriter;

    public CodeGenerator(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;

        try {
            fileWriter = new FileWriter(outputFileName);
        } catch (IOException io) {
            System.err.println("The output file " + outputFileName + " cant be open.");
            return;
        }
    }

    public void closeWriter() {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.err.println("Error closing the output file: " + outputFileName);
            }
        }
    }

    private void printlnt(String str) {
        println("\t" + str);
    }

    private void println(String str) {
        try {
            fileWriter.write(str + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enter(int numberOfBytesLocal) {
        printlnt("enter " + numberOfBytesLocal);
    }

    public void add(Type type) {
        printlnt("add" + type.suffix());
    }

    public void mul(Type type) {
        printlnt("mul" + type.suffix());
    }

    public void pusha(int offset) {
        printlnt("pusha " + offset);
    }

    public void pushbp() {
        printlnt("push bp");
    }

    public void push(char value) {
        printlnt("pushb " + (int) value);
    }

    public void push(int value) {
        printlnt("pushi " + value);
    }

    public void push(double value) {
        printlnt("pushf " + value);
    }

    public void comment(String str) {
        printlnt("' * " + str);
    }

    public void ret(int numerOfBytesReturnType, int numberOfBytesLocal, int numberOfBytesParam) {
        printlnt("ret\t" + numerOfBytesReturnType + ", " + numberOfBytesLocal + ", " + numberOfBytesParam);
    }

    public void varDefinitionComment(VariableDefinition variableDefinition) {
        String type = variableDefinition.getType().toString();
        String name = variableDefinition.getName();
        int offset = variableDefinition.offset;

        comment(type + " " + name + " (offset " + offset + ")");
    }

    public void load(Type type) {
        printlnt("load" + type.suffix());
    }

    public void store(Type type) {
        printlnt("store" + type.suffix());
    }

    public void in(Type type) {
        printlnt("in" + type.suffix());
    }

    public void out(Type type) {
        printlnt("out" + type.suffix());
    }

    public void callMain() {
        println("\n' Invocation to the main function");
        println("call main");
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
        printlnt("b2i");
    }

    public void i2b() {
        printlnt("i2b");
    }

    public void i2f() {
        printlnt("i2f");
    }

    public void f2i() {
        printlnt("f2i");
    }

    public void arithmetic(Type type, String operator) {
        switch (operator) {
            case "+":
                add(type);
                break;
            case "-":
                printlnt("sub" + type.suffix());
                break;
            case "*":
                mul(type);
                break;
            case "/":
                printlnt("div" + type.suffix());
                break;
            case "%":
                printlnt("mod" + type.suffix());
                break;
        }
    }

    public void comparasion(Type type, String operator) {
        switch (operator) {
            case ">":
                printlnt("gt" + type.suffix());
                break;
            case "<":
                printlnt("lt" + type.suffix());
                break;
            case ">=":
                printlnt("ge" + type.suffix());
                break;
            case "<=":
                printlnt("le" + type.suffix());
                break;
            case "==":
                printlnt("eq" + type.suffix());
                break;
            case "!=":
                printlnt("ne" + type.suffix());
                break;
        }

    }

    public void logical(String operator) {
        switch (operator) {
            case "&&":
                printlnt("and");
                break;
            case "||":
                printlnt("or");
                break;
        }
    }

    public void not() {
        printlnt("not");
    }

    public void principalDirective(String inputFileName) {
        directiveln("source " + "'" + inputFileName + "'" + "\n");
    }

    public void directiveln(String str) {
        println("\n#" + str);
    }

    public void lineDirective(int line) {
        directiveln("line " + line);
    }

    public void name(String name) {
        println("\n " + name + ":");
    }
}
