package symboltable;

import ast.definitions.Definition;

import java.util.List;
import java.util.Map;

public class SymbolTable {
	
	private int scope=0;
	private List<Map<String,Definition>> table;
	public SymbolTable()  {
	}

	public void set() {
	}
	
	public void reset() {
	}
	
	public boolean insert(Definition definition) {
		return false;
	}
	
	public Definition find(String id) {
		return null;
	}

	public Definition findInCurrentScope(String id) {
		return null;
	}
}
