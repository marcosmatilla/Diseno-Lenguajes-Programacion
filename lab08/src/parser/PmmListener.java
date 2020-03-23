// Generated from C:/Users/Marcos/Desktop/INFORMATICA/TERCERO/2/DLP/lab/DLP_1920/lab07/src/parser\Pmm.g4 by ANTLR 4.8
package parser;

    import ast.*;
    import ast.Program;
    import ast.definitions.Definition;
    import ast.definitions.FunctionDefinition;
    import ast.definitions.VariableDefinition;
    import ast.expresions.*;
    import ast.statements.*;
    import ast.types.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PmmParser}.
 */
public interface PmmListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PmmParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(PmmParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(PmmParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(PmmParser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(PmmParser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#function_type}.
	 * @param ctx the parse tree
	 */
	void enterFunction_type(PmmParser.Function_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#function_type}.
	 * @param ctx the parse tree
	 */
	void exitFunction_type(PmmParser.Function_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(PmmParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(PmmParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(PmmParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(PmmParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#variable_definition}.
	 * @param ctx the parse tree
	 */
	void enterVariable_definition(PmmParser.Variable_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#variable_definition}.
	 * @param ctx the parse tree
	 */
	void exitVariable_definition(PmmParser.Variable_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#function_body}.
	 * @param ctx the parse tree
	 */
	void enterFunction_body(PmmParser.Function_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#function_body}.
	 * @param ctx the parse tree
	 */
	void exitFunction_body(PmmParser.Function_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PmmParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PmmParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#simple_type}.
	 * @param ctx the parse tree
	 */
	void enterSimple_type(PmmParser.Simple_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#simple_type}.
	 * @param ctx the parse tree
	 */
	void exitSimple_type(PmmParser.Simple_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#return_type}.
	 * @param ctx the parse tree
	 */
	void enterReturn_type(PmmParser.Return_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#return_type}.
	 * @param ctx the parse tree
	 */
	void exitReturn_type(PmmParser.Return_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(PmmParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(PmmParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#struct_type}.
	 * @param ctx the parse tree
	 */
	void enterStruct_type(PmmParser.Struct_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#struct_type}.
	 * @param ctx the parse tree
	 */
	void exitStruct_type(PmmParser.Struct_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#struct_fields}.
	 * @param ctx the parse tree
	 */
	void enterStruct_fields(PmmParser.Struct_fieldsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#struct_fields}.
	 * @param ctx the parse tree
	 */
	void exitStruct_fields(PmmParser.Struct_fieldsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PmmParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PmmParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(PmmParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(PmmParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(PmmParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(PmmParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(PmmParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(PmmParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void enterReturn_statement(PmmParser.Return_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#return_statement}.
	 * @param ctx the parse tree
	 */
	void exitReturn_statement(PmmParser.Return_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#assigment}.
	 * @param ctx the parse tree
	 */
	void enterAssigment(PmmParser.AssigmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#assigment}.
	 * @param ctx the parse tree
	 */
	void exitAssigment(PmmParser.AssigmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(PmmParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(PmmParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void enterWhile_statement(PmmParser.While_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#while_statement}.
	 * @param ctx the parse tree
	 */
	void exitWhile_statement(PmmParser.While_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#invokeFunction}.
	 * @param ctx the parse tree
	 */
	void enterInvokeFunction(PmmParser.InvokeFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#invokeFunction}.
	 * @param ctx the parse tree
	 */
	void exitInvokeFunction(PmmParser.InvokeFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PmmParser#expressions}.
	 * @param ctx the parse tree
	 */
	void enterExpressions(PmmParser.ExpressionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PmmParser#expressions}.
	 * @param ctx the parse tree
	 */
	void exitExpressions(PmmParser.ExpressionsContext ctx);
}