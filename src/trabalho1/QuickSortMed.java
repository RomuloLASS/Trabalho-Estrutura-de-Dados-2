package trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QuickSortMed extends QuickSortN {

    public QuickSortMed(Registro[] vetor) {
        super(vetor);
    }

    //Funcao principal da classe, chamada no main
    public void Organiza() throws IOException {
        long tempoInicial = System.currentTimeMillis();
        Imprime();
        System.out.println("-----------------");
        quickSort(0, vetor.length - 1);
        long tempoFinal = System.currentTimeMillis();
        Imprime();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
        System.out.println("O numero de comparações é " + comp);
        System.out.println("O numero de copias de registro é " + copia);

        //Referencia o arquivo na pasta
        File arquivo = new File("saidaQuickSortMed.txt");

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
    @Override
    public void quickSort(int esq, int dir) {
        int tam = dir - esq + 1;
        if (tam <= 3) {
            if (tam <= 1) {
                return;
            }
            if (tam == 2) {
                if (vetor[esq].id > vetor[dir].id) {
                    comp++;
                    troca(esq, dir);
                }
                return;
            } else 
                if (vetor[esq].id > vetor[dir - 1].id) {
                    comp++;
                    troca(esq, dir - 1);
                }
                if (vetor[esq].id> vetor[dir].id) {
                    comp++;
                    troca(esq, dir);
                }
                if (vetor[dir - 1].id > vetor[dir].id) {
                    comp++;
                    troca(dir - 1, dir);
                }
        } else {
            double mediano = mediano(esq, dir);
            int particao = particao(esq, dir, mediano);
            quickSort(esq, particao - 1);
            quickSort(particao + 1, dir);
        }
    }

    //Funcao auxiliar de ordenacao
    public int mediano(int esq, int dir) {
        int mediano = (esq + dir) / 2;

        if (vetor[esq].id > vetor[mediano].id) {
            troca(esq, mediano);
            comp++;
        }

        if (vetor[esq].id > vetor[dir].id) {
            troca(esq, dir);
            comp++;
        }

        if (vetor[mediano].id > vetor[dir].id) {
            troca(mediano, dir);
            comp++;
        }
        troca(mediano, dir - 1);
        return vetor[dir - 1].id;
    }

    //Funcao auxiliar de ordenacao
    public void troca(int a, int d) {
        int aux = vetor[a].id;
        vetor[a].id = vetor[d].id;
        vetor[d].id = aux;
        copia+=3;
    }

    //Funcao auxiliar de ordenacao
    public int particao(int esq, int dir, double pivo) {
        int esqParticao = esq;
        int dirParticao = dir - 1;
        copia+=2;

        while (true) {
            while (vetor[++esqParticao].id < pivo); //Percorre da esquerda para a direita até encontrar alguem maior que o pivo
            while (vetor[--dirParticao].id > pivo); //Percorre da direita para a esquerda até encontrar alguem menor que o pivo
            if (esqParticao >= dirParticao) {
                comp++;
                break;
            } else {
                comp++;
                troca(esqParticao, dirParticao);     
            }
        }
        troca(esqParticao, dir - 1);
        return esqParticao;
    }
}
