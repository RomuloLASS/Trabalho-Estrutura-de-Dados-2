package trabalho1;

import trabalho1.Hash;
import trabalho1.Hash;
import trabalho1.Hash;

public class SondagemLinear extends Hash {

    //Construtor
    public SondagemLinear(int tamTabela) {
        super(tamTabela);
    }

    //Funcao hash utilizada
    @Override
    int hash(int valor, int colisoes) {
        return (valor + colisoes) % tamanhoDaTabela;
    }

}
