package ast.expresions;

public class CharLiteral extends AbstractExpresion {
    private char value;
    public CharLiteral(int line, int column, char value) {
        super(line, column);
        this.value=value;
    }

    @Override
    public String toString() {
        return "CharLiteral{" +
                "value=" + value +
                '}';
    }
}
