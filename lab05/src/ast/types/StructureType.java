package ast.types;

import java.util.ArrayList;

public class StructureType extends AbstractType {
    private ArrayList<StructureField> structureFields;

    public StructureType(int line, int column, ArrayList<StructureField> structureFields) {
        super(line, column);
        this.structureFields = structureFields;
    }

    public ArrayList<StructureField> getStructureFields() {
        return structureFields;
    }

    public void setStructureFields(ArrayList<StructureField> structureFields) {
        this.structureFields = structureFields;
    }

    @Override
    public String toString() {
        return "StructureType{" +
                "structureFields=" + structureFields +
                '}';
    }
}
