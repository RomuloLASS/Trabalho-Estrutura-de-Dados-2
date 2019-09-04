package trabalho1;

import java.lang.Math;
import trabalho1.Hash;
import trabalho1.Hash;
import trabalho1.Hash;

public class SondagemQuadratica extends Hash {

    //Construtor
    public SondagemQuadratica(int tamTabela) {
        super(tamTabela);
    }

    //Função hash utilizada
    @Override
    int hash(int valor, int colisoes) {
        return (int) (valor + Math.pow(colisoes, 2)) % tamanhoDaTabela;
    }
}
