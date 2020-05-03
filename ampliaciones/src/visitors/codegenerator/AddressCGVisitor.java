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
         w[9]:int; -> [0,2,(5),8] queremos w[2]
         */
        indexer.getExpresion1().accept(this, param); //dirección de w   [0]
        indexer.getExpresion2().accept(valueCGVisitor, param); //valor de la posicion [0,2] (el 2 es la posicion a la que queremos acceder)

        //cg.convert(indexer.getExpresion2().getType(), IntType.getInstance());

        cg.push(indexer.getType().numberOfBytes()); //[0,2,2] -> ultimo 2 pr lo q ocupan los enteros
        cg.mul(IntType.getInstance()); // [0,4]
        cg.add(IntType.getInstance()); // [4] direccion del segunda posiocion

        return null;
    }
}
