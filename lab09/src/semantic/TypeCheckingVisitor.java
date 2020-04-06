package semantic;

import ast.expresions.*;
import ast.statements.*;
import ast.types.CharType;
import ast.types.ErrorType;
import ast.types.IntType;
import ast.types.RealType;
import visitors.AbstratVisitor;

public class TypeCheckingVisitor extends AbstratVisitor {
    @Override
    public Object visit(IfElse ifElse, Object param) {
        ifElse.getExpresion().accept(this, param);
        if(!ifElse.getExpresion().getType().isLogical())
            ifElse.getExpresion().setType(new ErrorType(ifElse.getExpresion().getLine(), ifElse.getExpresion().getColumn(), "Logical Type Expected"));
        ifElse.getIfs().forEach(x -> x.accept(this, param));

        ifElse.getElses().forEach(x->x.accept(this, param));
        return null;
    }

    @Override
    public Object visit(While _while, Object param) {
        _while.getExpresion().accept(this, param); //condicion

        if(!_while.getExpresion().getType().isLogical())
            _while.getExpresion().setType(new ErrorType( _while.getExpresion().getLine(), _while.getExpresion().getColumn(),"Logical Type Expected"));
        for(Statement s: _while.getStatements()){ //cuerpo
            s.accept(this, param);
        }
        return null;
    }

    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        arithmetic.getExpresion1().accept(this, param);
        arithmetic.getExpresion2().accept(this, param);

        arithmetic.setType(arithmetic.getExpresion1().getType().arithmetic(arithmetic.getExpresion2().getType()));
        if(arithmetic.getType()==null){
            arithmetic.setType(new ErrorType(arithmetic.getLine(), arithmetic.getColumn(),"Incompatible types"));
        }

        arithmetic.setLValue(false);
        return null;
    }

    @Override
    public Object visit(Assigment assigment, Object param) {
        super.visit(assigment, param);
        if(!assigment.getExpresion1().getLValue()){
            new ErrorType(assigment.getLine(), assigment.getColumn(), "Expression " + assigment.getExpresion1().toString() + " is not lvalue");
        }
        assigment.getExpresion1().setType(assigment.getExpresion1().getType().promotesTo(assigment.getExpresion2().getType()));
        if(assigment.getExpresion1().getType() == null){
            assigment.getExpresion1().setType(new ErrorType(assigment.getLine(), assigment.getColumn(), "Right expression " + assigment.getExpresion2() + " can not be assigned for left expression "+ assigment.getExpresion1()+ " because their types"));
        }
        return null;
    }

    @Override
    public Object visit(Input input, Object param) {
        super.visit(input, param);
        if(!input.getExpresion().getLValue()){
            new ErrorType(input.getLine(), input.getColumn(), "Expression " + input.getExpresion().toString() + " is not lvalue");
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
        charLiteral.setType(CharType.getInstance());
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
        fieldAccess.getExpresion().setType(fieldAccess.getExpresion().getType().dot(fieldAccess.getCampo()));
        if(fieldAccess.getType() == null)
            fieldAccess.getExpresion().setType(new ErrorType(fieldAccess.getLine(), fieldAccess.getColumn(), "Field " + "'" + fieldAccess.getCampo()  + "'" + " not defined"));
        fieldAccess.setLValue(true);
        return null;
    }

    @Override
    public Object visit(Indexer indexer, Object param) {
        indexer.getExpresion1().accept(this, param);
        indexer.getExpresion2().accept(this, param);
        indexer.setLValue(true);
        return null;
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        super.visit(intLiteral, param);
        intLiteral.setLValue(false);
        intLiteral.setType(IntType.getInstance());
        return null;
    }

    @Override
    public Object visit(Logic logic, Object param) {
        super.visit(logic, param);
        logic.setLValue(false);
        logic.getExpresion1().setType(logic.getExpresion1().getType().logic(logic.getExpresion2().getType()));
        if(logic.getExpresion1().getType() == null){
            logic.getExpresion1().setType(new ErrorType(logic.getLine(), logic.getColumn(), "Incompatible types"));
        }
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
        realLiteral.setType(RealType.getInstance());
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
        variable.setLValue(true);
        if(variable.definition.getType()!=null)
            variable.setType(variable.definition.getType());
        return null;
    }

    @Override
    public Object visit(InvokeFunction invokeFunction, Object param) {
        super.visit(invokeFunction, param);
        invokeFunction.setLValue(false);
        return null;
    }
}
