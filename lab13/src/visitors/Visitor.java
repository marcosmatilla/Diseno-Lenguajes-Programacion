package visitors;

import ast.Program;
import ast.definitions.FunctionDefinition;
import ast.definitions.VariableDefinition;
import ast.expresions.*;
import ast.statements.*;
import ast.types.*;

public interface Visitor {

    /* Expressions */
    Object visit(Arithmetic arithmetic, Object param);

    Object visit(Cast cast, Object param);

    Object visit(CharLiteral charLiteral, Object param);

    Object visit(Comparation comparation, Object param);

    Object visit(FieldAccess fieldAccess, Object param);

    Object visit(Indexer indexer, Object param);

    Object visit(IntLiteral intLiteral, Object param);

    Object visit(Logic logic, Object param);

    Object visit(Negation negation, Object param);

    Object visit(RealLiteral realLiteral, Object param);

    Object visit(UnaryMinus unaryMinus, Object param);

    Object visit(Variable variable, Object param);

    /* Statement-Expression */
    Object visit(InvokeFunction invokeFunction, Object param);

    Object visit (AssigmentWith assigmentWith, Object param);

    /* Statement */
    Object visit(Assigment assigment, Object param);

    Object visit(IfElse ifElse, Object param);

    Object visit(Input input, Object param);

    Object visit(Print print, Object param);

    Object visit(Return _return, Object param);

    Object visit(While _while, Object param);

    /* Type */
    Object visit(ArrayType arrayType, Object param);

    Object visit(CharType charType, Object param);

    Object visit(FunctionType functionType, Object param);

    Object visit(IntType intType, Object param);

    Object visit(RealType realType, Object param);

    Object visit(StructureField structureField, Object param);

    Object visit(StructureType structureType, Object param);

    Object visit(VoidType voidType, Object param);

    /* Error */
    Object visit(ErrorType errorType, Object param);

    /* Definition */
    Object visit(FunctionDefinition functionDefinition, Object param);

    Object visit(VariableDefinition variableDefinition, Object param);

    /* Program */
    Object visit(Program program, Object param);

}
