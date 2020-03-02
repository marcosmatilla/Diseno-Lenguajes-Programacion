package ast;

import ast.statements.Statement;
import ast.types.Type;

import java.util.ArrayList;

public class FunctionDefinition implements Definition {
    private Type type;
    private String name;
    private ArrayList<Statement> statements;

    public FunctionDefinition(Type type, String name, ArrayList<Statement> statements) {
        this.type = type;
        this.name = name;
        this.statements = statements;
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
