package ast.semantic;

import ast.expresions.*;
import ast.statements.Assigment;
import ast.statements.Input;
import ast.types.ErrorType;
import ast.visitors.AbstratVisitor;

public class TypeVisitor extends AbstratVisitor {
    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        super.visit(arithmetic, param);
        arithmetic.setLValue(false);
        return null;
    }

    @Override
    public Object visit(Assigment assigment, Object param) {
        super.visit(assigment, param);
        if(!assigment.getExpresion1().getLValue()){
            new ErrorType(assigment.getLine(), assigment.getColumn(), "Expression " + assigment.getExpresion1().toString() + "is not lvalue");
        }
        return null;
    }

    @Override
    public Object visit(Input input, Object param) {
        super.visit(input, param);
        if(!input.getExpresion().getLValue()){
            new ErrorType(input.getLine(), input.getColumn(), "Expression " + input.getExpresion().toString() + "is not lvalue");
        }
        return null;
    }

    @Override
    public Object visit(Cast cast, Object param) {
        super.visit(cast, param);
        cast.setLValue(false);
        return null;
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object param) {
        super.visit(charLiteral, param);
        charLiteral.setLValue(false);
        return null;
    }

    @Override
    public Object visit(Comparation comparation, Object param) {
        super.visit(comparation, param);
        comparation.setLValue(false);
        return null;
    }

    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        super.visit(fieldAccess, param);
        fieldAccess.setLValue(true);
        return null;
    }

    @Override
    public Object visit(Indexer indexer, Object param) {
        super.visit(indexer, param);
        indexer.setLValue(true);
        return null;
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        super.visit(intLiteral, param);
        intLiteral.setLValue(false);
        return null;
    }

    @Override
    public Object visit(Logic logic, Object param) {
        super.visit(logic, param);
        logic.setLValue(false);
        return null;
    }

    @Override
    public Object visit(Negation negation, Object param) {
        super.visit(negation, param);
        negation.setLValue(false);
        return null;
    }

    @Override
    public Object visit(RealLiteral realLiteral, Object param) {
        super.visit(realLiteral, param);
        realLiteral.setLValue(false);
        return null;
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object param) {
        super.visit(unaryMinus, param);
        unaryMinus.setLValue(false);
        return null;
    }

    @Override
    public Object visit(Variable variable, Object param) {
        super.visit(variable, param);
        variable.setLValue(true);
        return null;
    }

    @Override
    public Object visit(InvokeFunction invokeFunction, Object param) {
        super.visit(invokeFunction, param);
        invokeFunction.setLValue(false);
        return null;
    }
}
