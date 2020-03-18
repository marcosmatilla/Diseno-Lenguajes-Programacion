package ast.expresions;

import ast.visitors.Visitor;

public class Comparation extends AbstractExpresion {
    private Expresion expresion1;
    private Expresion expresion2;
    private String operador;

    public Comparation(int line, int column, Expresion expresion1, Expresion expresion2, String operador) {
        super(line, column);
        this.expresion1 = expresion1;
        this.expresion2 = expresion2;
        this.operador = operador;
    }

    public Expresion getExpresion1() {
        return expresion1;
    }

    public void setExpresion1(Expresion expresion1) {
        this.expresion1 = expresion1;
    }

    public Expresion getExpresion2() {
        return expresion2;
    }

    public void setExpresion2(Expresion expresion2) {
        this.expresion2 = expresion2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    @Override
    public String toString() {
        return "Comparation{" +
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
