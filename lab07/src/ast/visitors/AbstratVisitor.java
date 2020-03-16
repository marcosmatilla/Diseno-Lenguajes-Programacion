package ast.visitors;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;

public abstract class AbstratVisitor implements Visitor{
    @Override
    public Object visit(Arithmetic arithmetic, Object object) {
        return null;
    }

    @Override
    public Object visit(Cast cast, Object object) {
        return null;
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object object) {
        return null;
    }

    @Override
    public Object visit(Comparation comparation, Object object) {
        return null;
    }

    @Override
    public Object visit(FieldAccess fieldAccess, Object object) {
        return null;
    }

    @Override
    public Object visit(Indexer indexer, Object object) {
        return null;
    }

    @Override
    public Object visit(Logic logic, Object object) {
        return null;
    }

    @Override
    public Object visit(Negation negation, Object object) {
        return null;
    }

    @Override
    public Object visit(RealLiteral realLiteral, Object object) {
        return null;
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object object) {
        return null;
    }

    @Override
    public Object visit(Variable variable, Object object) {
        return null;
    }

    @Override
    public Object visit(InvokeFunction invokeFunction, Object object) {
        return null;
    }

    @Override
    public Object visit(Assigment assigment, Object object) {
        return null;
    }

    @Override
    public Object visit(IfElse ifElse, Object object) {
        return null;
    }

    @Override
    public Object visit(Input input, Object object) {
        return null;
    }

    @Override
    public Object visit(Print print, Object object) {
        return null;
    }

    @Override
    public Object visit(Return _return, Object object) {
        return null;
    }

    @Override
    public Object visit(While _while, Object object) {
        return null;
    }

    @Override
    public Object visit(ArrayType arrayType, Object object) {
        return null;
    }

    @Override
    public Object visit(CharType charType, Object object) {
        return null;
    }

    @Override
    public Object visit(FunctionType functionType, Object object) {
        return null;
    }

    @Override
    public Object visit(IntType intType, Object object) {
        return null;
    }

    @Override
    public Object visit(RealType realType, Object object) {
        return null;
    }

    @Override
    public Object visit(StructureField structureField, Object object) {
        return null;
    }

    @Override
    public Object visit(StructureType structureType, Object object) {
        return null;
    }

    @Override
    public Object visit(VoidType voidType, Object object) {
        return null;
    }

    @Override
    public Object visit(ErrorType errorType, Object object) {
        return null;
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object object) {
        return null;
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object object) {
        return null;
    }

    @Override
    public Object visit(Program program, Object object) {
        return null;
    }
}
