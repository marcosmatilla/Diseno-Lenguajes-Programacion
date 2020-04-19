package visitors;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;

public abstract class AbstratVisitor implements Visitor{

    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        arithmetic.expresion1.accept(this, param);
        arithmetic.expresion2.accept(this, param);
        return null;
    }

    @Override
    public Object visit(Cast cast, Object param) {
        cast.getType().accept(this, param);
        cast.getExpresion().accept(this, param);
        return null;
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object param) {
        return null;
    }

    @Override
    public Object visit(Comparation comparation, Object param) {
        comparation.getExpresion1().accept(this, param);
        comparation.getExpresion2().accept(this, param);
        return null;
    }

    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        fieldAccess.getExpresion().accept(this, param);
        return null;
    }

    @Override
    public Object visit(Indexer indexer, Object param) {
        indexer.getExpresion1().accept(this, param);
        indexer.getExpresion2().accept(this, param);
        return null;
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        return null;
    }

    @Override
    public Object visit(Logic logic, Object param) {
        logic.getExpresion1().accept(this, param);
        logic.getExpresion2().accept(this, param);
        return null;
    }

    @Override
    public Object visit(Negation negation, Object param) {
        negation.getExpresion().accept(this, param);
        return null;
    }

    @Override
    public Object visit(RealLiteral realLiteral, Object param) {
        return null;
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object param) {
        unaryMinus.getExpresion().accept(this, param);
        return null;
    }

    @Override
    public Object visit(Variable variable, Object param) {
        return null;
    }

    @Override
    public Object visit(InvokeFunction invokeFunction, Object param) {
        invokeFunction.getVariable().accept(this, param);
        invokeFunction.getExpresions().forEach( x -> x.accept(this, param));
        return null;
    }

    @Override
    public Object visit(Assigment assigment, Object param) {
        assigment.getExpresion1().accept(this, param);
        assigment.getExpresion2().accept(this, param);
        return null;
    }

    @Override
    public Object visit(IfElse ifElse, Object param) {
        ifElse.getExpresion().accept(this, param);
        ifElse.getIfs().forEach(x -> x.accept(this, param));
        ifElse.getElses().forEach(x -> x.accept(this, param));
        return null;
    }

    @Override
    public Object visit(Input input, Object param) {
        input.getExpresion().accept(this, param);
        return null;
    }

    @Override
    public Object visit(Print print, Object param) {
        print.getExpresion().accept(this, param);
        return null;
    }

    @Override
    public Object visit(Return _return, Object param) {
        _return.getExpresion().accept(this, param);
        return null;
    }

    @Override
    public Object visit(While _while, Object param) {
        _while.getExpresion().accept(this, param);
        _while.getStatements().forEach(x -> x.accept(this, param));
        return null;
    }

    @Override
    public Object visit(ArrayType arrayType, Object param) {
        arrayType.getType().accept(this, param);
        return null;
    }

    @Override
    public Object visit(CharType charType, Object param) {
        return null;
    }

    @Override
    public Object visit(FunctionType functionType, Object param) {
        functionType.getVariableDefinitions().forEach(x -> x.accept(this, param));
        functionType.getReturnType().accept(this, param);
        return null;
    }

    @Override
    public Object visit(IntType intType, Object param) {

        return null;
    }

    @Override
    public Object visit(RealType realType, Object param) {
        return null;
    }

    @Override
    public Object visit(StructureField structureField, Object param) {
        structureField.getType().accept(this, param);
        return null;
    }

    @Override
    public Object visit(StructureType structureType, Object param) {
        structureType.getStructureFields().forEach(x -> x.getType().accept(this, param));
        return null;
    }

    @Override
    public Object visit(VoidType voidType, Object param) {
        return null;
    }

    @Override
    public Object visit(ErrorType errorType, Object param) {

        return null;
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object param) {
        functionDefinition.getType().accept(this, param);
        functionDefinition.getStatements().forEach(x -> x.accept(this, param));
        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object param) {
        variableDefinition.getType().accept(this, param);
        return null;
    }

    @Override
    public Object visit(Program program, Object param) {
        for(Definition d: program.getDefinitions())
            d.accept(this, param);
        return null;
    }
}
