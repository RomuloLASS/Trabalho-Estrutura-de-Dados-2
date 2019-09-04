package trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QuickSortIns extends QuickSortN {

    //Construtor
    public QuickSortIns(Registro[] vetor) {
        super(vetor);
    }
    
    //Funcao principal da classe, chamada no main
    public void Organiza(int m) throws IOException {
        long tempoInicial = System.currentTimeMillis();
        quickSort(0, vetor.length-1,m);
        long tempoFinal = System.currentTimeMillis();
        Imprime();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
        System.out.println("O numero de comparações é " + comp);
        System.out.println("O numero de copias de registro é " + copia);
        
        //Referencia o arquivo na pasta
        File arquivo = new File("saidaQuickSortIns.txt");
        
        //Se o arquivo nao existir na pasta, ele cria
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        //Prepara para escrever no arquivo criado
        BufferedWriter saida = new BufferedWriter(new FileWriter(arquivo.getAbsoluteFile()));

        //Escreve e fecha o arquivo
        saida.write("Numero de comparações: " + comp + "\r\nCópias de registro: " + copia + "\r\nTempo de execução: " + (tempoFinal-tempoInicial)+" ms");
        saida.close();
    }

    //Faz a ordenacao do vetor
    protected void quickSort(int esq, int dir, int m) {       
        int tam = dir - esq + 1;
        if (tam <= m) {
            InsertionSort(dir, esq);
        } else {
            int pivo = particiona(esq, dir);
            int particao = particiona(esq, dir);
            quickSort(esq, particao - 1);
            quickSort(particao + 1, dir);
        }
    }

    //Funcao auxiliar de ordenacao
    private void InsertionSort(int dir, int esq) {
        int j, chave,i;
        Registro aux[] = new Registro[vetor.length];
        for (j = esq+1; j <= dir; j++) {
            chave = vetor[j].id;
            copia++;
            for (i = j-1; (i >= 0) && (vetor[i].id > chave); i--) {
                aux[j] = vetor[j+1];
                vetor[j+1] = vetor[j];
                vetor[j] = aux[j];
                copia++;
                comp++;
            }
            comp++;
            vetor[i + 1].id = chave;
            copia++;
        }
    }
}
