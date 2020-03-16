package ast.visitors;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;

public interface Visitor {

    /* Expressions */
    Object visit(Arithmetic arithmetic, Object object);
    Object visit(Cast cast, Object object);
    Object visit(CharLiteral charLiteral, Object object);
    Object visit(Comparation comparation, Object object);
    Object visit(FieldAccess fieldAccess, Object object);
    Object visit(Indexer indexer, Object object);
    Object visit(Logic logic, Object object);
    Object visit(Negation negation, Object object);
    Object visit(RealLiteral realLiteral, Object object);
    Object visit(UnaryMinus unaryMinus, Object object);
    Object visit(Variable variable, Object object);

    /* Statement-Expression */
    Object visit(InvokeFunction invokeFunction, Object object);

    /* Statement */
    Object visit(Assigment assigment, Object object);
    Object visit(IfElse ifElse, Object object);
    Object visit(Input input, Object object);
    Object visit(Print print, Object object);
    Object visit(Return _return, Object object);
    Object visit(While _while, Object object);

    /* Type */
    Object visit(ArrayType arrayType, Object object);
    Object visit(CharType charType, Object object);
    Object visit(FunctionType functionType, Object object);
    Object visit(IntType intType, Object object);
    Object visit(RealType realType, Object object);
    Object visit(StructureField structureField, Object object);
    Object visit(StructureType structureType, Object object);
    Object visit(VoidType voidType, Object object);

    /* Error */
    Object visit(ErrorType errorType, Object object);

    /* Definition */
    Object visit(FunctionDefinition functionDefinition, Object object);
    Object visit(VariableDefinition variableDefinition, Object object);

    /* Program */
    Object visit(Program program, Object object);
}
