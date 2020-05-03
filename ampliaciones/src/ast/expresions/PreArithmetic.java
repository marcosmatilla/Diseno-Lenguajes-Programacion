package ast.expresions;

import ast.statements.Statement;
import visitors.Visitor;

public class PreArithmetic extends AbstractExpresion implements Statement {
    private Expresion expression;



    private String operador;

    public PreArithmetic(int line, int column, Expresion expression, String operador) {
        super(line, column);
        this.expression = expression;
        this.operador = operador;

    }

    public Expresion getExpression() {
        return expression;
    }

    public String getOperador() {
        return operador;
    }

    @Override
    public String toString() {
        return "PostArithmetic " + expression + operador;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
