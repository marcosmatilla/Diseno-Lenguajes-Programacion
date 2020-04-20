package visitors.codegenerator;

import ast.expresions.*;

public class ValueCGVisitor extends AbstractCGVisitor{

    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        /*
        * value[[IntLiteral: expression -> INT_CONSTANT]]() =
        *   <pushi> expression.value
        */
        return super.visit(intLiteral, param);
    }

    @Override
    public Object visit(RealLiteral realLiteral, Object param) {
        /*
         * value[[RealLiteral: expression -> REAL_CONSTANT]]() =
         *   <pushf> expression.value
         */
        return super.visit(realLiteral, param);
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object param) {
        /*
         * value[[CharLiteral: expression -> CHAR_CONSTANT]]() =
         *   <pushb> expression.value
         */
        return super.visit(charLiteral, param);
    }

    @Override
    public Object visit(Cast cast, Object param) {
        /*
         * value[[Cast: expression1 -> type expression2]]() =
         *      value[[expression2]]
         *      expression2.type.suffix to expression1.type.suffix //
         *
         */
        return super.visit(cast, param);
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object param) {
        /*
         *
         *
         */
        return super.visit(unaryMinus, param);
    }

    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        /*
         *
         *
         */
        return super.visit(fieldAccess, param);
    }

    @Override
    public Object visit(Indexer indexer, Object param) {
        /*
         *
         *
         */
        return super.visit(indexer, param);
    }

    @Override
    public Object visit(Variable variable, Object param) {
        /*
         * value[[Variable: expression -> ID]]() =
         *   address[[expression]]()
         *   <load> expression.type.suffix()
         */
        return super.visit(variable, param);
    }

    @Override
    public Object visit(Arithmetic arithmetic, Object param) {
        /*
         * value[[Arithmetic: expression -> expressionL operator expressionR]]() =
         *      value[[expressionL]]
         *      value[[expressionR]]
         *      switch(expression.operator):
         *          case("+"): <add> expresssion.type.suffix()
         *          case("-"): <sub> expresssion.type.suffix()
         *          case("*"): <mul> expresssion.type.suffix()
         *          case("/"): <div> expresssion.type.suffix()
         */
        return super.visit(arithmetic, param);
    }

    @Override
    public Object visit(Comparation comparation, Object param) {
        /*
         * value[[Comparation: expression -> expressionL operator expressionR]]() =
         *      value[[expressionL]]
         *      value[[expressionR]]
         *      switch(expression.operator):
         *          case(">"): <gt> expresssion.type.suffix()
         *          case("<"): <lt> expresssion.type.suffix()
         *          case(">="): <ge> expresssion.type.suffix()
         *          case("<="): <le> expresssion.type.suffix()
         *          case("=="): <ne> expresssion.type.suffix()
         *          case("!="): <e> expresssion.type.suffix()
         */
        return super.visit(comparation, param);
    }

    @Override
    public Object visit(Logic logic, Object param) {
        /*
         * value[[Logic: expression -> expressionL operator expressionR]]() =
         *      value[[expressionL]]
         *      value[[expressionR]]
         *      switch(expression.operator):
         *          case("&&"): and
         *          case("||"): or
         */
        return super.visit(logic, param);
    }

}
