package ast.expresions;

public class CharLiteral extends AbstractExpresion {
    public CharLiteral(int line, int column) {
        super(line, column);
    }

    @Override
    public String toString() {
        return "CharLiteral{}";
    }
}
