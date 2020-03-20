package dlp.expresions;

import java.util.ArrayList;

public class InvokeFunction extends AbstractExpresion {
    private ArrayList<Expresion> expresions;

    public InvokeFunction(int line, int column, ArrayList<Expresion> expresions) {
        super(line, column);
        this.expresions = expresions;
    }
}
