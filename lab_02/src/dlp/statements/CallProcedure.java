package dlp.statements;

import dlp.expresions.Expresion;
import dlp.expresions.Variable;

import java.util.ArrayList;

public class CallProcedure extends AbstractStatement {
    private Variable variable;
    private ArrayList<Expresion> calls;

    public CallProcedure(int line, int column, Variable variable, ArrayList<Expresion> calls) {
        super(line, column);
        this.variable = variable;
        this.calls = calls;
    }
}
