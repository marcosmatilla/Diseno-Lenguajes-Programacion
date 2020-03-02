package ast;

import ast.statements.Statement;
import ast.types.Type;

public abstract class AbstractVarDef implements Definition, Statement {
    private int line;
    private int column;
    private Type type;
    private String name;

    public AbstractVarDef(int line, int column, Type type, String name) {
        this.line = line;
        this.column = column;
        this.type = type;
        this.name = name;
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
    public Type getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }
}
