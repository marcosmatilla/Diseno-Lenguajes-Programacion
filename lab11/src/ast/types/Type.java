package ast.types;

import ast.ASTNode;
import ast.expresions.Expresion;

import java.util.ArrayList;

public interface Type extends ASTNode {
    boolean isLogical();

    Type arithmetic(Type type);

    Type arithmetic();

    Type promotesTo(Type type);

    Type dot(String campo);

    Type logic(Type type);

    Type comparasion(Type type);

    Type logic();

    Type parenthesis(ArrayList<Expresion> expresions);

    boolean isBuiltInType();

    Type canBeCastTo(Type type);

    Type squareBrackets(Type type);

    int numberOfBytes();

    StructureField get(String string);

    char suffix();
}
