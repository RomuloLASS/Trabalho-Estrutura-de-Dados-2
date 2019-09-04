package trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HeapSort {

    private Registro[] vetor;
    private int comp = 0;
    private int copia = 0;

    //Construtor
    public HeapSort(Registro[] vetor) {
        this.vetor = vetor;
    }
    
    //Funcao principal da classe, chamada no main
    public void Organiza() throws IOException {
        long tempoInicial = System.currentTimeMillis();
        heapsort();
        long tempoFinal = System.currentTimeMillis();
        Imprime();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
        System.out.println("O numero de comparações é " + comp);
        System.out.println("O numero de copias de registro é " + copia);
        
        //Referencia o arquivo na pasta
        File arquivo = new File("saidaHeapSort.txt");
        
        //Se o arquivo nao existir na pasta, ele cria
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        //Prepara para escrever no arquivo criado
        BufferedWriter saida = new BufferedWriter(new FileWriter(arquivo.getAbsoluteFile()));

        //Escreve e fecha arquivo
        saida.write("Numero de comparações: " + comp + "\r\nCópias de registro: " + copia + "\r\nTempo de execução: " + (tempoFinal-tempoInicial)+" ms");
        saida.close();
    }
    
    //Faz a ordenacao do vetor
    public void heapsort() {

        for (int i = vetor.length / 2 - 1; i >= 0; i--) {
            heapify(vetor.length, i);
        }

        for (int i = vetor.length - 1; i >= 0; i--) {
            Registro aux = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = aux;
            copia += 3;
            heapify(i, 0);
        }
    }

    //Funcao auxiliar de ordenacao
    private void heapify(int n, int i) {
        int maior = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && vetor[l].id > vetor[maior].id) {
            maior = l;
        }
        if (r < n && vetor[r].id > vetor[maior].id) {
            maior = r;
        }
        comp += 2;
        if (maior != i) {
            Registro aux = vetor[i];
            vetor[i] = vetor[maior];
            vetor[maior] = aux;
            copia += 2;
            heapify(n, maior);
        }
    }
    
    //Funcao para imprimir 
    private void Imprime() {
        for(int i=0;i<vetor.length;i++){
            System.out.println(vetor[i].id);  
        } 
    }
}
