package semantic;

import ast.definitions.FunctionDefinition;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;
import visitors.AbstratVisitor;

public class TypeCheckingVisitor extends AbstratVisitor {
    @Override
    public Object visit(IfElse ifElse, Object param) {
        ifElse.getExpresion().accept(this, param);
        if (!ifElse.getExpresion().getType().isLogical())
            ifElse.getExpresion().setType(new ErrorType(ifElse.getExpresion().getLine(), ifElse.getExpresion().getColumn(), "Logical Type Expected"));

        ifElse.getIfs().forEach(x -> x.accept(this, param));
        ifElse.getElses().forEach(x -> x.accept(this, param));

        return null;
    }

    @Override
    public Object visit(While _while, Object param) {
        _while.getExpresion().accept(this, param); //condicion

        if (!_while.getExpresion().getType().isLogical())
            _while.getExpresion().setType(new ErrorType(_while.getExpresion().getLine(), _while.getExpresion().getColumn(), "Logical Type Expected"));
        for (Statement s : _while.getStatements()) { //cuerpo
            s.accept(this, param);
        }

        return null;
    }

    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        arithmetic.getExpresion1().accept(this, param);
        arithmetic.getExpresion2().accept(this, param);

        arithmetic.setLValue(false);

        arithmetic.setType(arithmetic.getExpresion1().getType().arithmetic(arithmetic.getExpresion2().getType()));
        if (arithmetic.getType() == null) {
            arithmetic.setType(new ErrorType(arithmetic.getLine(), arithmetic.getColumn(), "Incompatible types"));
        }


        return null;
    }

    @Override
    public Object visit(Assigment assigment, Object param) {
        assigment.getExpresion1().accept(this, param);
        assigment.getExpresion2().accept(this, param);

        if (!assigment.getExpresion1().getLValue()) {
            new ErrorType(assigment.getLine(), assigment.getColumn(), "Expression " + assigment.getExpresion1().toString() + " is not lvalue");
        }

        if (assigment.getExpresion2().getType().promotesTo(assigment.getExpresion1().getType()) == null) {
            assigment.getExpresion1().setType(new ErrorType(assigment.getLine(), assigment.getColumn(), "Could not perform assignment of types " + assigment.getExpresion1().getType() + " and " + assigment.getExpresion2().getType()));
        }
        return null;
    }

    @Override
    public Object visit(Input input, Object param) {
        super.visit(input, param);
        if (!input.getExpresion().getLValue()) {
            new ErrorType(input.getLine(), input.getColumn(), "Expression " + input.getExpresion().toString() + " is not lvalue");
        }
        return null;
    }

    @Override
    public Object visit(Cast cast, Object param) {
        super.visit(cast, param);
        cast.setLValue(false);
        cast.setType(cast.getExpresion().getType().canBeCastTo(cast.getType()));
        if (cast.getType() == null)
            cast.setType(new ErrorType(cast.getLine(), cast.getColumn(), "The expression " + "'" + cast.getExpresion() + "'" + " can not be casted to " + "'" + cast.getType() + "'"));
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
        comparation.setType(comparation.getExpresion1().getType().comparasion(comparation.getExpresion2().getType()));
        if (comparation.getExpresion1().getType() == null)
            comparation.setType(new ErrorType(comparation.getLine(), comparation.getColumn(), "Incompatible types for comparation"));
        return null;
    }

    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        fieldAccess.getExpresion().accept(this, param);

        fieldAccess.setType(fieldAccess.getExpresion().getType().dot(fieldAccess.getCampo()));
        if (fieldAccess.getType() == null)
            fieldAccess.setType(new ErrorType(fieldAccess.getLine(), fieldAccess.getColumn(), "Field " + "'" + fieldAccess.getCampo() + "'" + " not defined"));
        fieldAccess.setLValue(true);
        return null;
    }

    @Override
    public Object visit(Indexer indexer, Object param) {
        indexer.getExpresion1().accept(this, param);
        indexer.getExpresion2().accept(this, param);

        indexer.setLValue(true);

        indexer.setType(indexer.getExpresion1().getType().squareBrackets(indexer.getExpresion2().getType()));
        if (indexer.getType() == null)
            indexer.setType(new ErrorType(indexer.getLine(), indexer.getColumn(), "Invalid access array"));
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
        logic.setType(logic.getExpresion1().getType().logic(logic.getExpresion2().getType()));
        if (logic.getExpresion1().getType() == null) {
            logic.setType(new ErrorType(logic.getLine(), logic.getColumn(), "Incompatible types expected"));
        }
        return null;
    }

    @Override
    public Object visit(Negation negation, Object param) {
        super.visit(negation, param);
        negation.setLValue(false);
        negation.setType(negation.getExpresion().getType().logic());
        if (negation.getExpresion().getType() == null)
            negation.setType(new ErrorType(negation.getLine(), negation.getColumn(), "You can only deny integers"));
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
        unaryMinus.setType(unaryMinus.getExpresion().getType().arithmetic());
        if (unaryMinus.getType() == null)
            unaryMinus.setType(new ErrorType(unaryMinus.getLine(), unaryMinus.getColumn(), "Expression " + "'" + unaryMinus.getExpresion() + "'" + " can not use unary minus"));
        return null;
    }

    @Override
    public Object visit(Variable variable, Object param) {
        variable.setLValue(true);
        if (variable.definition.getType() != null)
            variable.setType(variable.definition.getType());
        return null;
    }

    @Override
    public Object visit(InvokeFunction invokeFunction, Object param) {
        invokeFunction.getVariable().accept(this, param);
        invokeFunction.getExpresions().forEach(x -> x.accept(this, param));

        invokeFunction.setLValue(false);
        invokeFunction.setType(invokeFunction.getVariable().getType().parenthesis(invokeFunction.getExpresions()));
        if (invokeFunction.getType() == null) {
            invokeFunction.setType(new ErrorType(invokeFunction.getLine(), invokeFunction.getColumn(), "Wrong parameters in the invocation"));
        }
        return null;
    }

    @Override
    public Object visit(Return _return, Object returnType) { //param -> returnType
        super.visit(_return, returnType);
        if (_return.getExpresion().getType().getClass() != returnType.getClass()) {
            new ErrorType(_return.getLine(), _return.getColumn(), "Return type does not coincide was expected " + "'" + returnType + "'" + " and received " + "'" + _return.getExpresion().getType() + "'");
        }
        if (!_return.getExpresion().getType().isBuiltInType()) {
            new ErrorType(_return.getLine(), _return.getColumn(), "Return type must be built in type");
        }
        return null;
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object param) {
        functionDefinition.getType().accept(this, param);
        functionDefinition.getStatements().forEach(x -> x.accept(this, ((FunctionType) functionDefinition.getType()).getReturnType()));
        return null;
    }

    @Override
    public Object visit(FunctionType functionType, Object param) {
        functionType.getVariableDefinitions().forEach(x -> x.accept(this, param));
        functionType.getReturnType().accept(this, param);
        return null;
    }
}
