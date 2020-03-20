package dlp.expresions;

public class FieldAccess extends AbstractExpresion {
    private Expresion expresion;

    public FieldAccess(int line, int column) {
        super(line, column);
    }
}
