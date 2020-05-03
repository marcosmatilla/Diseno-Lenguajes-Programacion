package visitors.codegenerator;

import ast.expresions.*;
import ast.types.CharType;
import ast.types.IntType;
import ast.types.Type;
import codegenerator.CodeGenerator;

public class ValueCGVisitor extends AbstractCGVisitor {
    private CodeGenerator cg;
    private AddressCGVisitor addressCGVisitor;

    public ValueCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    public void setAddressCGVisitor(AddressCGVisitor addressCGVisitor) {
        this.addressCGVisitor = addressCGVisitor;
    }

    @Override
    public Object visit(IntLiteral intLiteral, Object param) {
        /*
         * value[[IntLiteral: expression -> INT_CONSTANT]]() =
         *   <pushi> expression.value
         */
        cg.push(intLiteral.value);

        return null;
    }

    @Override
    public Object visit(RealLiteral realLiteral, Object param) {
        /*
         * value[[RealLiteral: expression -> REAL_CONSTANT]]() =
         *   <pushf> expression.value
         */
        cg.push(realLiteral.value);

        return null;
    }

    @Override
    public Object visit(CharLiteral charLiteral, Object param) {
        /*
         * value[[CharLiteral: expression -> CHAR_CONSTANT]]() =
         *   <pushb> expression.value
         */
        cg.push(charLiteral.value);

        return null;
    }

    @Override
    public Object visit(Cast cast, Object param) {
        /*
         * value[[Cast: expression1 -> type expression2]]() =
         *      value[[expression2]]
         *      expression2.type.suffix to expression1.type.suffix
         *
         */
        cast.getExpresion().accept(this, param);
        cg.convert(cast.getExpresion().getType(), cast.getType());

        return null;
    }

    @Override
    public Object visit(UnaryMinus unaryMinus, Object param) {
        /*
         *  value[[UnaryMinus: expression -> expressionR]]() =
         *      value[[expressionR]]
         *      <push> -1
         *      <mul> expression.type.suffix()
         */
        unaryMinus.getExpresion().accept(this, param);
        cg.push(-1);
        cg.convert(IntType.getInstance(), unaryMinus.getType());
        cg.mul(unaryMinus.getType());

        return null;
    }

    @Override
    public Object visit(Negation negation, Object param) {
        /*
         *  value[[Negation: expression -> expressionR]]() =
         *      value[[expressionR]]
         *      <not>
         */
        negation.getExpresion().accept(this, param);

        cg.convert(negation.getExpresion().getType(), negation.getType());
        cg.not();

        return null;
    }

    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        /*
         *  value[[FieldAccess: expression -> expressionR campo]]
         *      address[[expression]]()
         *      <load> expression.type.suffix()
         */
        fieldAccess.accept(addressCGVisitor, param);
        cg.load(fieldAccess.getType());

        return null;
    }

    @Override
    public Object visit(Indexer indexer, Object param) {
        /*
         *  value[[Indexer: expression -> expressionL expressionR]]
         *      address[[expression]]()
         *      <load> expression.type.suffix()
         */
        indexer.accept(addressCGVisitor, param);
        cg.load(indexer.getType());

        return null;
    }

    @Override
    public Object visit(Variable variable, Object param) {
        /*
         * value[[Variable: expression -> ID]]() =
         *   address[[expression]]()
         *   <load> expression.type.suffix()
         */
        variable.accept(addressCGVisitor, param);
        cg.load(variable.getType());

        return null;
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
         *          case("*"): <mul> expression.type.suffix()
         *          case("/"): <div> expresssion.type.suffix()
         *          case("&"): <mod> expression.type.suffix()
         */
        arithmetic.getExpresion1().accept(this, param);
        cg.convert(arithmetic.getExpresion1().getType(), arithmetic.getType());

        arithmetic.getExpresion2().accept(this, param);
        cg.convert(arithmetic.getExpresion2().getType(), arithmetic.getType());

        cg.arithmetic(arithmetic.getType(), arithmetic.getOperador());

        return null;
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
        comparation.getExpresion1().accept(this, param);
        cg.convert(comparation.getExpresion1().getType(), comparation.getExpresion2().getType());

        comparation.getExpresion2().accept(this, param);
        cg.convert(comparation.getExpresion2().getType(), comparation.getExpresion2().getType());

        cg.comparasion(comparation.getType(), comparation.getOperador());

        return null;
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

        // a ^ 23
        if (logic.getOperador().equals("^")) {
            logic.getExpresion1().accept(this, param); //A
            logic.getExpresion2().accept(this, param); //B
            cg.not();
            cg.and();

            logic.getExpresion2().accept(this, param); //B
            logic.getExpresion1().accept(this, param); //A
            cg.not();
            cg.and();
            cg.or();

        } else {
            logic.getExpresion1().accept(this, param);
            cg.convert(logic.getExpresion1().getType(), logic.getType());


            logic.getExpresion2().accept(this, param);
            cg.convert(logic.getExpresion2().getType(), logic.getType());

            cg.logical(logic.getOperador());
        }


        return null;
    }

    @Override
    public Object visit(InvokeFunction invokeFunction, Object param) {
        /*
         * value[[InvokeFunction: expression1 -> expression2 expression*]]() =
         *      for(Expression exp: expression*)
         *          value[[exp]]
         *      <call> expression2.name
         */
        invokeFunction.getExpresions().forEach(expr -> expr.accept(this, null));
        cg.call(invokeFunction.getVariable().getName());

        return null;
    }

    @Override
    public Object visit(PostArithmetic postArithmetic, Object param) {
        /*
         * value[[PostArithmetic: statement, expression -> expr2 operador]]() =
         *      if(type instanceof CharType)
         *          convert(char,int)
         *      <push> 1
         *      switch(expression.operator):
         *          case '--' <sub> postAr.type.suffix
                    case '++' <add> postAr.type.suffix
         *      if(type instanceof CharType)
         *          convert(int, char)
         *       <store> postAr.type
         */
        Type type = postArithmetic.getExpression().getType() instanceof CharType ? IntType.getInstance() : postArithmetic.getType();

        postArithmetic.getExpression().accept(this, param);                // VALUE[[expr]]
        postArithmetic.getExpression().accept(addressCGVisitor, param);    // ADDRESS[[expr]]
        postArithmetic.getExpression().accept(this, param);                // VALUE[[expr]]

        // Si la expresion es char, hay que convertirla a entero primero, para sumarle 1
        if (postArithmetic.getExpression().getType() instanceof CharType)
            cg.convert(CharType.getInstance(), IntType.getInstance());

        cg.push(1);
        cg.convert(IntType.getInstance(), type);

        cg.arth(type, postArithmetic.getOperador());

        // Si la expresion es char, despues de convertirla en entero y sumarle 1, la volvemos a convertir en char
        if (postArithmetic.getExpression().getType() instanceof CharType)
            cg.convert(IntType.getInstance(), CharType.getInstance());

        cg.store(postArithmetic.getType());

        return null;
    }

    @Override
    public Object visit(PreArithmetic preArithmetic, Object param) {
        /*
         *
         *
         */
        Type type = preArithmetic.getExpression().getType() instanceof CharType ? IntType.getInstance() : preArithmetic.getType();

        preArithmetic.getExpression().accept(addressCGVisitor, param);        // ADDRESS[[expr]]
        preArithmetic.getExpression().accept(this, param);                // VALUE[[expr]]

        // Si la expresion es char, hay que convertirla a entero primero, para sumarle 1
        if (preArithmetic.getExpression().getType() instanceof CharType)
            cg.convert(CharType.getInstance(), IntType.getInstance());

        cg.push(1);
        cg.convert(IntType.getInstance(), type);

        cg.arth(type, preArithmetic.getOperador());

        // Si la expresion es char, despues de convertirla en entero y sumarle 1, la volvemos a convertir en char
        if (preArithmetic.getExpression().getType() instanceof CharType)
            cg.convert(IntType.getInstance(), CharType.getInstance());

        cg.store(preArithmetic.getType());

        preArithmetic.getExpression().accept(this, param);                // VALUE[[expr]]

        return null;
    }
}
