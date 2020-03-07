package ast.types;

public class RealType extends AbstractType {
    public RealType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "RealType{}";
    }
}
