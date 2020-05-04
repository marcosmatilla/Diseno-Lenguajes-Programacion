package ast.types;

import ast.AbstractASTNode;
import ast.expresions.Expresion;
import java.util.ArrayList;

public abstract class AbstractType extends AbstractASTNode implements Type {

    public AbstractType(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean isLogical() {
        return false;
    }

    @Override
    public Type promotesTo(Type type) { return null; }

    @Override
    public Type arithmetic(Type type) {
        return null;
    }

    @Override
    public Type dot(String campo) { return null; }

    @Override
    public Type logic(Type type) {
        return null;
    }

    @Override
    public Type comparasion(Type type) {
        return null;
    }

    @Override
    public Type logic() {
        return null;
    }

    @Override
    public Type parenthesis(ArrayList<Expresion> expresions) {
        return null;
    }

    @Override
    public boolean isBuiltInType() {
        return false;
    }

    @Override
    public Type canBeCastTo(Type type) {
        return null;
    }

    @Override
    public Type arithmetic() {
        return null;
    }

    @Override
    public Type squareBrackets(Type type) {
        return null;
    }

    @Override
    public int numberOfBytes() {
        return 0;
    }

    @Override
    public StructureField get(String string) {
        return null;
    }

    @Override
    public char suffix() {
        return  ' ';
    }

    @Override
    public Type assignWith(Type type) {
        return null;
    }
}
