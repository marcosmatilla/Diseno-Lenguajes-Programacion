package ast.types;

public class StructureField {
    private String name;
    private Type type;

    public StructureField(String name, Type type) {
        this.name = name;
        this.type = type;
    }
}
