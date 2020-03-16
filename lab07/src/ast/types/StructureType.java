package ast.types;

import java.util.ArrayList;

public class StructureType extends AbstractType {
    private ArrayList<StructureField> structureFields;

    public StructureType(int line, int column, ArrayList<StructureField> structureFields) {
        super(line, column);
        this.structureFields = structureFields;
        check();
    }

    private void check() {
        ArrayList<String> aux = new ArrayList<String>();
        for(StructureField sf: structureFields) {
            if (aux.contains(sf.getName())) {
                new ErrorType(getLine(), getColumn(), "The struct fild " + "'" + sf.getName()+ "'" + " has already been defined in the struct");
            } else {
                aux.add(sf.getName());
            }
        }
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
