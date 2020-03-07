package ast.types;

public class CharType extends AbstractType {
    public CharType(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "CharType{}";
    }
}

