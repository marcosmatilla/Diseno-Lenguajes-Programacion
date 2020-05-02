package symboltable;

import ast.definitions.Definition;
import ast.definitions.VariableDefinition;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SymbolTable {

    private int scope = 0;
    private List<Map<String, Definition>> table;

    public SymbolTable() {
        table = new LinkedList<Map<String, Definition>>();
        table.add(new HashMap<String, Definition>());
    }

    public void set() {
        scope++;
        table.add(new HashMap<String, Definition>());
    }

    public void reset() {
        table.remove(scope);
        scope--;
    }

    public boolean insert(Definition definition) {
        if (findInCurrentScope(definition.getName()) != null) {
            return false;
        }

        if (definition instanceof VariableDefinition) {
            definition.setScope(scope);
        }
        table.get(scope).put(definition.getName(), definition);
        return true;
    }

    public Definition find(String id) {
        for (int i = (table.size() - 1); i >= 0; i--) {
            if (table.get(i).containsKey(id)) {
                return table.get(i).get(id);
            }
        }
        return null;
    }

    public Definition findInCurrentScope(String id) {
        return table.get(scope).get(id);
    }
}
