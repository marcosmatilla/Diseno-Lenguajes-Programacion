package ast;

import ast.definitions.Definition;
import ast.types.ErrorType;
import ast.visitors.Visitor;

import java.util.ArrayList;

public class Program implements ASTNode {
    private int line;
    private int column;
    private ArrayList<Definition> definitions;

    public Program(int line, int column, ArrayList<Definition> definitions) {
        this.line = line;
        this.column = column;
        this.definitions = definitions;
        check();
    }

    public ArrayList<Definition> getDefinitions() {
        return definitions;
    }

    private void check() {
        ArrayList<String> aux = new ArrayList<String>();
        for(Definition d: definitions) {
            if (aux.contains(d.getName())) {
                new ErrorType(d.getLine(), d.getColumn(), "The variable definition " + "'" + d.getName()+ "'" + " has already been defined");
            } else {
                aux.add(d.getName());
            }
        }
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "Program{" +
                "line=" + line +
                ", column=" + column +
                ", definitions=" + definitions +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
