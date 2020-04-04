package ast.types;

import visitors.Visitor;

public class RealType extends AbstractType {

    public RealType() {
        super(0, 0);
    }

    public RealType(int line, int column) {
        super(line, column);
    }

    private static RealType instance = new RealType();
    public static RealType getInstance() { return instance; }

    @Override
    public String toString() {
        return "real";
    }

    @Override
    public Type arithmetic(Type type) {
        if(type.equals(RealType.getInstance()) || type instanceof ErrorType)
            return type;
        return null;
    }

    @Override
    public Object accept(Visitor v, Object param) {
        return v.visit(this, param);
    }
}
