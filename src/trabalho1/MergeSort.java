package trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MergeSort {

    private Registro[] vetor;
    private Registro[] copiaV;
    protected int comp = 0;
    protected int copia = 0;

    //Construtor
    public MergeSort(Registro[] vetor) {
        this.vetor = vetor;
        this.copiaV = new Registro[vetor.length];
    }

    //Funcao principal da classe, chamada no main
    public void Organiza() throws IOException {
        long tempoInicial = System.currentTimeMillis();
        mergeSort(0, vetor.length - 1);
        long tempoFinal = System.currentTimeMillis();
        Imprime();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
        System.out.println("O numero de comparações é " + comp);
        System.out.println("O numero de copias de registro é " + copia);

        //Referencia o arquivo na pasta
        File arquivo = new File("saidaMergeSort.txt");

        //Se o arquivo nao existir na pasta, ele cria
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        //Prepara para escrever no arquivo criado
        BufferedWriter saida = new BufferedWriter(new FileWriter(arquivo.getAbsoluteFile()));

        //Escreve e fecha arquivo
        saida.write("Numero de comparações: " + comp + "\r\nCópias de registro: " + copia + "\r\nTempo de execução: " + (tempoFinal - tempoInicial) + " ms");
        saida.close();
    }

    //Faz a ordenacao do vetor
    private void mergeSort(int esq, int dir) {
        if (esq < dir) {
            int meio = esq + (dir - esq) / 2;
            mergeSort(esq, meio);
            mergeSort(meio + 1, dir);
            merge(esq, meio, dir);
        }
    }

    //Funcao auxiliar de ordenacao
    private void merge(int esq, int meio, int dir) {
        for (int i = esq; i <= dir; i++) {
            copiaV[i] = vetor[i];
            //copia++;//ACHO Q N PRECISA DESSA COPIA
        }
        int i = esq, j = meio + 1, k = esq;
        while (i <= meio && j <= dir) {
            if (copiaV[i].id <= copiaV[j].id) {
                vetor[k] = copiaV[i];
                i++;
                copia++;
                //comp++;
            } else {
                vetor[k] = copiaV[j];
                j++;
                copia++;
                //comp++;
            }
            comp++;// ESSE COMP N PODE FICAR FORA DO IF E ELSE ?
            k++;
        }
        while (i <= meio) {
            vetor[k] = copiaV[i];
            k++;
            i++;
            copia++;//PRECISA DASSA COPIA ??
        }
    }

    //Funcao para imprimir 
    protected void Imprime() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i].id);
        }
    }
}
