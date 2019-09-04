package trabalho1;

import trabalho1.Registro;

public abstract class Hash {

    protected final int tamanhoDaTabela;
    private Registro[] tabelaHash;
    private int colisoes = 0;
    private int comp = 0;

    //Construtor, inicializa a tabela hash com -1
    public Hash(int tamTabela) {
        tamanhoDaTabela = tamTabela;
        tabelaHash = new Registro[tamTabela];
        for (int i = 0; i < tamTabela; i++) {
            tabelaHash[i] = new Registro(-1);
        }
    }

    //Imprime a tabela hash
    public void imprimeTabelaHash() {
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < tabelaHash.length; i++) {
            if (tabelaHash[i].id != -1) {
                System.out.println("[Posição na tabela: " + i + "] Chave: " + tabelaHash[i].getId());
            }
        }
        System.out.println("Número de colisões: " + colisoes);
        System.out.println("Número de chaves comparadas: " + comp);
    }

    //Função Hash, usada nas outras classes
    int hash(int valor, int colisao) {
        return 0;
    }

    //Insere a chave na tabela hash, se possivel
    boolean insere(int chave) {
        boolean existe = busca(chave);
        int indice;
        if (existe == false) {
            for (int j = 0; j < tamanhoDaTabela; j++) {
                indice = hash(chave, j);
                if (tabelaHash[indice].id == -1) {
                    tabelaHash[indice].id = chave;
                    comp++;
                    return true;
                } else {
                    colisoes++;
                    comp++;
                }
            }
        } else 
            return false;
        return false;
    }

    //Busca a chave na tabela hash
    boolean busca(int chave) {
        int indice;
        for (int j = 0; j < tamanhoDaTabela; j++) {
            indice = hash(chave, j);
            if (tabelaHash[indice].id == -1) {
                return false;
            } else if (tabelaHash[indice].id != -1 && tabelaHash[indice].id == chave) {
                comp++;
                return true;
            }
        }
        return false;
    }

    //remove a chave da tabela hash
    boolean remove(int chave) {
        boolean existe = busca(chave);
        int indice;
        if (existe == true) {
            for (int j = 0; j < tamanhoDaTabela; j++) {
                indice = hash(chave, j);
                if (tabelaHash[indice].id != -1 && tabelaHash[indice].id == chave) {
                    tabelaHash[indice].id = -1;
                    comp++;
                    System.out.println("Chave removida com sucesso.");
                    return true;
                }
            }
        } else {
            System.out.println("Chave não encontrada");
            return false;
        }
        return false;
    }

}
