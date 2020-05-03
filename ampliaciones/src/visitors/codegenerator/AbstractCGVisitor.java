package visitors.codegenerator;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;
import visitors.Visitor;

public class AbstractCGVisitor implements Visitor {

    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(Cast cast, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(Comparation comparation, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(Indexer indexer, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(Logic logic, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(Negation negation, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(RealLiteral realLiteral, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(Variable variable, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(InvokeFunction invokeFunction, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(PostArithmetic postArithmetic, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(PreArithmetic preArithmetic, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(Assigment assigment, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(IfElse ifElse, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(Input input, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(Print print, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(Return _return, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(While _while, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(ArrayType arrayType, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(CharType charType, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(FunctionType functionType, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(IntType intType, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(RealType realType, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(StructureField structureField, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(StructureType structureType, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(VoidType voidType, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(ErrorType errorType, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(FunctionDefinition functionDefinition, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(VariableDefinition variableDefinition, Object param) {
        throw new IllegalStateException("Error");
    }

    @Override
    public Object visit(Program program, Object param) {
        throw new IllegalStateException("Error");
    }
}
