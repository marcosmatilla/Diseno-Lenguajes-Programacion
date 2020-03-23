package ast.definitions;

import ast.AbstractASTNode;
import ast.types.Type;

public abstract class AbstractDefinition extends AbstractASTNode implements Definition {

    private String name;
    private Type type;
    private int scope;

    public AbstractDefinition(int line, int column, String name, Type type) {
        super(line, column);
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public void setScope(int scope) { this.scope = scope; }

    public int getScope() { return this.scope; }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
