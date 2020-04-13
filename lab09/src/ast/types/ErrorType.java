package ast.types;

import ast.ASTNode;
import ast.expresions.Expresion;
import errorhandler.ErrorHandler;
import visitors.Visitor;

import java.util.ArrayList;

public class ErrorType extends AbstractType {
    private String message;

    public ErrorType(int line, int column, String message) {
        super(line, column);
        this.message = message;
        ErrorHandler.getEH().AddError(this);
    }

    public ErrorType(ASTNode node, String message) {
        this(node.getLine(), node.getColumn(), message);
    }

    @Override
    public Type promotesTo(Type type) {
        return this;
    }

    @Override
    public Type arithmetic(Type type) {
        return this;
    }

    @Override
    public Type dot(String campo) {
        return this;
    }

    @Override
    public Type logic(Type type) {
        return this;
    }

    @Override
    public Type comparasion(Type type) {
        return this;
    }

    @Override
    public Type logic() {
        return this;
    }

    @Override
    public Type parenthesis(ArrayList<Expresion> expresions) {
        return this;
    }

    @Override
    public Type canBeCastTo(Type type) {
        return this;
    }

    @Override
    public Type arithmetic() {
        return this;
    }

    @Override
    public Type squareBrackets(Type type) {
        return this;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }

    @Override
    public String toString() {
        return "line=" + getLine() + " column=" + getColumn() +
                " message='" + message + '\'' ;
    }
}
