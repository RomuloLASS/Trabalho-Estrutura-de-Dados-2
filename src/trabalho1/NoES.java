package trabalho1;

public class NoES {// Nos do encadeamento separado

    private Registro registro;
    private NoES prox;

    public NoES(Registro registro) {
        this.registro = registro;
    }

    public Registro getRegistro() {
        return registro;
    }

    public NoES getProx() {
        return prox;
    }

    public void setProx(NoES prox) {
        this.prox = prox;
    }
}
