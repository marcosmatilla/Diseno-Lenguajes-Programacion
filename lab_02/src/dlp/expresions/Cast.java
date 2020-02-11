package dlp.expresions;

import dlp.types.Type;

public class Cast extends AbstractExpresion {
    private Expresion expresion;
    private Type type;

    public Cast(int line, int column, Expresion expresion, Type type) {
        super(line, column);
        this.expresion = expresion;
        this.type = type;
    }
}
