package trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QuickSortN {

    protected Registro[] vetor;
    protected int comp = 0;
    protected int copia = 0;

    //Construtor
    public QuickSortN(Registro[] vetor) {
        this.vetor = vetor;
    }

    //Funcao principal da classe, chamada no main
    public void Organiza() throws IOException {
        long tempoInicial = System.currentTimeMillis();
        quickSort(0, vetor.length - 1);
        long tempoFinal = System.currentTimeMillis();
        Imprime();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
        System.out.println("O numero de comparações é " + comp);
        System.out.println("O numero de copias de registro é " + copia);
        
        //Referencia o arquivo na pasta
        File arquivo = new File("saidaQuickSortN.txt");
        
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

    //Funcao para imprimir 
    protected void Imprime() {
        for(int i=0;i<vetor.length;i++){
            System.out.println(vetor[i].id);
        }   
    }

    //Faz a ordenacao do vetor
        protected void quickSort(int esq, int dir) {//divide o vetor em dois subvetores
        if (esq < dir) {
            int pivo = particiona(esq, dir);
            quickSort(esq, pivo - 1);
            quickSort(pivo + 1, dir);
        }
    }

    //Funcao auxiliar de ordenacao
    protected int particiona(int esq, int dir) {//organiza os subvetores e seleciona a nova divisao
        int pivo = vetor[esq].id;
        int i = esq + 1, d = dir;
        Registro[] aux = new Registro[vetor.length];
        while (i <= d) {
            if (vetor[i].id <= pivo) {
                i++;
                comp++;
            } else if (pivo < vetor[d].id) {
                d--;
                comp++;
            } else {
                aux[i] = vetor[i];
                vetor[i] = vetor[d];
                vetor[d] = aux[i];
                i++;
                d--;
                comp++;
                copia=+3;
            }
            //comp++;
        }
        aux[1] = vetor[esq];
        vetor[esq] = vetor[d];
        vetor[d] = aux[1];
        
        vetor[d].id = pivo;
        copia=+3;
        copia++;
        return d;
    }
}
