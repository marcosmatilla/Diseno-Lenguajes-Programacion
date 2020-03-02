package ast;

import java.util.ArrayList;

public class Program implements ASTNode {
    private int line;
    private int column;
    private ArrayList<Definition> definitions;

    public Program(int line, int column, ArrayList<Definition> definitions) {
        this.line = line;
        this.column = column;
        this.definitions = definitions;

    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }
}
