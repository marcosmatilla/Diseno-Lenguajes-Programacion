package ast.expresions;

import ast.statements.Statement;
import visitors.Visitor;

public class AssigmentWith extends AbstractExpresion implements Statement {
    private Expresion expresion1;
    private Expresion expresion2;
    private String operador;

    public AssigmentWith(int line, int column, Expresion expresion1, Expresion expresion2, String operador) {
        super(line, column);
        this.expresion1 = expresion1;
        this.expresion2 = expresion2;
        this.operador = operador;
    }

    public Expresion getExpresion1() {
        return expresion1;
    }

    public Expresion getExpresion2() {
        return expresion2;
    }

    public String getOperador() {
        return operador;
    }

    @Override
    public String toString() {
        return "AssigmentWith{" +
                "expresion1=" + expresion1 +
                ", expresion2=" + expresion2 +
                ", operador='" + operador + '\'' +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
