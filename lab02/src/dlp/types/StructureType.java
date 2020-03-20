package dlp.types;

import java.util.ArrayList;

public class StructureType extends AbstractType {
    private Type type;
    private ArrayList<StructureField> structureFields;

    public StructureType(int line, int column, Type type, ArrayList<StructureField> structureFields) {
        super(line, column);
        this.type = type;
        this.structureFields = structureFields;
    }
}
