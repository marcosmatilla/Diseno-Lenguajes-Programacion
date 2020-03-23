package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;
import ast.visitors.Visitor;

import java.util.List;

public class FunctionDefinition extends AbstractDefinition {
    private List<Statement> statements;

    public FunctionDefinition(int line, int column, String name, Type type, List<Statement> statements) {
        super(line, column, name, type);
        this.statements=statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    public void setStatements(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public String toString() {
        return "FunctionDefinition{" +
                "statements=" + statements +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
