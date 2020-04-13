package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;
import visitors.Visitor;

public class VariableDefinition extends AbstractDefinition implements Statement {
    public int scope;
    public int offset;

    public VariableDefinition(int line, int column, String name, Type type) {
        super(line, column, name, type);
    }

    public void setScope(int scope){
        this.scope = scope;
    }

    public int getScope(){
        return scope;
    }

    public void setOffset(int offset){
        this.offset = offset;
    }

    public int getOffset(){ return offset; }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
