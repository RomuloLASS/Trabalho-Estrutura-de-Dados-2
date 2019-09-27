package trabalho1;

import static com.sun.org.apache.bcel.internal.classfile.Utility.printArray;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InsertionSort {

    private Registro[] vetor;
    private int comp = 0;
    private int copia = 0;

    //Construtor
    public InsertionSort(Registro[] vetor) {
        this.vetor = vetor;
    }

    //Funcao principal da classe, chamada no main
    public void Organiza() throws IOException {
        long tempoInicial = System.currentTimeMillis();
        Insertion();
        long tempoFinal = System.currentTimeMillis();
        Imprime();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
        System.out.println("O numero de comparações é " + comp);
        System.out.println("O numero de copias de registro é " + copia);

        //Referencia o arquivo na pasta
        File arquivo = new File("saidaInsertionSort.txt");
        
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
    private void Imprime() {
        for(int i=0;i<vetor.length;i++){
            System.out.println(vetor[i].id);
        }  
    }

//    //Faz a ordenacao do vetor
//    private void Insertion() {
//        int j, chave,i;
//        Registro aux[] = new Registro[vetor.length];
//        for (i = 1; i < vetor.length; i++) {
//            chave = vetor[i].id;
//            copia++;
//            for (j = i - 1; (j >= 0); j--) {
//                if(vetor[j].id > chave){
//                    aux[j] = vetor[j+1];
//                    vetor[j+1] = vetor[j];
//                    vetor[j] = aux[j];
//                    copia++;
//                    comp++;
//                } 
//            }
//            comp++;
//            vetor[j + 1].id = chave;
//            copia++;
//        }
//    }
    
    private void Insertion() {
        int n = vetor.length;  
        Registro aux[] = new Registro[vetor.length];
        for (int i = 1; i < n; i++){   
            int chave = vetor[i].id;  
            int j = i-1;  
            while ( (j > -1) && ( vetor [j].id > chave ) ) 
            {   
                aux[j] = vetor[j+1];
                vetor[j+1] = vetor[j];
                vetor[j] = aux[j];
                copia++;
                comp++;
                j--;  
            }  
            vetor[j+1].id = chave; 
        }  
    }
    
}
