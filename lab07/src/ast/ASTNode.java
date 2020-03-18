package ast;


import ast.visitors.Visitor;

public interface ASTNode {
    int getLine();
    int getColumn();

    Object accept(Visitor v, Object param);
}
