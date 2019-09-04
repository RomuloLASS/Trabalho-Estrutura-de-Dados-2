package trabalho1;

public class DuploHash extends Hash {

    //Construtor
    public DuploHash(int tamTabela) {
        super(tamTabela);
    }

    //Funcao hash utilizada
    int hash(int valor, int colisoes) {
        return (h1(valor) + colisoes * h2(valor)) % tamanhoDaTabela;
    }

    //Funcao hash auxiliar
    private int h1(int valor) {
        return valor % tamanhoDaTabela;
    }

    //Funcao hash auxiliar    
    private int h2(int valor) {
        return (5 + valor%13)%tamanhoDaTabela;
    }
}
