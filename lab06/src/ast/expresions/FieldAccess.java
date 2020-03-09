package ast.expresions;

public class FieldAccess extends AbstractExpresion {
    private Expresion expresion;
    private String campo;

    public FieldAccess(int line, int column, Expresion expresion, String campo) {
        super(line, column);
        this.expresion = expresion;
        this.campo = campo;
    }

    public Expresion getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresion expresion) {
        this.expresion = expresion;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    @Override
    public String toString() {
        return "FieldAccess{" +
                "expresion=" + expresion +
                ", campo='" + campo + '\'' +
                '}';
    }
}
