package ast;

import ast.types.Type;

public interface Definition {
    Type getType();
    String getName();
}
