// Generated from C:/Users/Marcos/Desktop/INFORMATICA/TERCERO/2/DLP/lab/DLP_1920/lab05/src/parser\Pmm.g4 by ANTLR 4.8
package parser;



import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PmmParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PmmVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PmmParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(PmmParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(PmmParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(PmmParser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(PmmParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(PmmParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#function_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_body(PmmParser.Function_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#variable_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_definition(PmmParser.Variable_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#variable_definitions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable_definitions(PmmParser.Variable_definitionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariables(PmmParser.VariablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PmmParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#simple_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_type(PmmParser.Simple_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#return_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_type(PmmParser.Return_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(PmmParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct(PmmParser.StructContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#struct_body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_body(PmmParser.Struct_bodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PmmParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(PmmParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRead(PmmParser.ReadContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#write}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWrite(PmmParser.WriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#return_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_statement(PmmParser.Return_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#assigment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssigment(PmmParser.AssigmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#ifElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElse(PmmParser.IfElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#while_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_statement(PmmParser.While_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(PmmParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#invokeFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvokeFunction(PmmParser.InvokeFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(PmmParser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link PmmParser#expressions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressions(PmmParser.ExpressionsContext ctx);
}