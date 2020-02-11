package dlp;

import dlp.statements.Statement;
import dlp.types.Type;

public class VariableDefinition extends AbstractVarDef {

    public VariableDefinition(int line, int column, Type type, String name) {
        super(line, column, type, name);
    }
}
