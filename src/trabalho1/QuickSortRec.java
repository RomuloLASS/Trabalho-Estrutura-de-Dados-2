package trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QuickSortRec extends QuickSortN {

    //Construtor
    public QuickSortRec(Registro[] vetor) {
        super(vetor);
    }
    
    //Funcao principal da classe, chamada no main
    @Override
    public void Organiza() throws IOException {
        long tempoInicial = System.currentTimeMillis();
        quickSort(0, vetor.length - 1);
        long tempoFinal = System.currentTimeMillis();
        Imprime();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
        System.out.println("O numero de comparações é " + comp);
        System.out.println("O numero de copias de registro é " + copia);
        
        //Referencia o arquivo na pasta
        File arquivo = new File("saidaQuickSortRec.txt");
        
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

}
