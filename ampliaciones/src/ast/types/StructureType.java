package ast.types;

import visitors.Visitor;

import java.util.ArrayList;

public class StructureType extends AbstractType {
    private ArrayList<StructureField> structureFields;

    public StructureType(int line, int column, ArrayList<StructureField> structureFields) {
        super(line, column);
        this.structureFields = structureFields;
        check();
    }

    public ArrayList<StructureField> getStructureFields() {
        return structureFields;
    }

    public void setStructureFields(ArrayList<StructureField> structureFields) {
        this.structureFields = structureFields;
    }

    private void check() {
        ArrayList<String> aux = new ArrayList<String>();
        for(StructureField sf: structureFields) {
            if (aux.contains(sf.getName())) {
                new ErrorType(sf.getLine(), sf.getColumn(), "The struct field " + "'" + sf.getName()+ "'" + " has already been defined in the struct");
            } else {
                aux.add(sf.getName());
            }
        }
    }

    @Override
    public Type dot(String campo) {
        for(StructureField sf: structureFields) {
            if(sf.getName().equals(campo)){
                return sf.getType();
            }
        }
        return null;
    }

    @Override
    public int numberOfBytes() {
        int nB = 0;
        for (StructureField sf: structureFields)
            nB += sf.getType().numberOfBytes();
        return nB;
    }

    @Override
    public StructureField get(String fieldName) {
        for (StructureField field : structureFields) {
            if(field.getName().equals(fieldName))
                return field;
        }
        return null;
    }

    @Override
    public String toString() {
        return "StructureType{" +
                "structureFields=" + structureFields +
                '}';
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
