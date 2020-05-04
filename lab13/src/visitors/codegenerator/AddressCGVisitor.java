package visitors.codegenerator;

import ast.definitions.VariableDefinition;
import ast.expresions.*;
import ast.types.*;
import codegenerator.CodeGenerator;

public class AddressCGVisitor extends AbstractCGVisitor {

    private CodeGenerator cg;
    private ValueCGVisitor valueCGVisitor;

    public AddressCGVisitor(CodeGenerator cg) {
        this.cg = cg;
    }

    public void setValueCGVisitor(ValueCGVisitor valueCGVisitor) {
        this.valueCGVisitor = valueCGVisitor;
    }

    @Override
    public Object visit(Variable variable, Object param) {
        /*
         * address[[Variable: expression -> ID]]() =
         *   if(expression.definition.scope == 0)
         *       <pusha> expression.definition.offset
         *   else
         *       <push bp>
         *       <pushi> expression.definition.offset
         *       <addi>
         */
        VariableDefinition varDef = (VariableDefinition) variable.getDefinition();
        if (varDef.getScope() == 0) {
            cg.pusha(varDef.getOffset());
        } else {
            cg.pushbp();
            cg.push(varDef.getOffset());
            cg.add(IntType.getInstance());
        }
        return null;
    }

    @Override
    public Object visit(FieldAccess fieldAccess, Object param) {
        /*
         *   address[[FieldAcess: expression -> expr name]]() =
         *       address[[expr]]
         *       <push> expr.type.get(name).offset
         *       <add>
         */
        fieldAccess.getExpresion().accept(this, param);
        StructureType structureType = (StructureType) fieldAccess.getExpresion().getType();
        cg.push(structureType.get(fieldAccess.getCampo()).getOffset());
        cg.add(IntType.getInstance());

        return null;
    }

    @Override
    public Object visit(Indexer indexer, Object param) {
        /*
         *  address[[Indexer: expression -> exprL exprR]]() =
         *      address[[exprL]]
         *      value[[exprR]]
         *      <push> expression.type.numBytes()
         *      <mul>
         *      <add>
         */
        indexer.getExpresion1().accept(this, param);
        indexer.getExpresion2().accept(valueCGVisitor, param);
        cg.push(indexer.getType().numberOfBytes());
        cg.mul(IntType.getInstance());
        cg.add(IntType.getInstance());

        return null;
    }

    @Override
    public Object visit(AssigmentWith assigmentWith, Object param) {
        assigmentWith.getExpresion1().accept(this, null);
        return null;
    }
}
