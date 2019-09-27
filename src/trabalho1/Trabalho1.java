package trabalho1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.nio.file.Files.lines;
import java.util.Random;
import java.util.Scanner;
import javax.xml.ws.Endpoint;

public class Trabalho1 {

    private static final String VIRGULA = ","; //Variavel utilizada para tratar a leitura do arquivo .csv

    public static Registro[] lerArquivo() throws IOException {
        
        int i = 0, j = 0; //Inicializa as váriaveis de controle com 0
        Random r = new Random(); //Classe para gerar numeros aleatórios
        Registro[] rw = new Registro[100000]; // Vetor contendo todos os registro lidos do documento .csv
        BufferedReader ler = new BufferedReader(new FileReader("entrada.txt")); // Arquivo de entrada contendo a quantidade de registros a ser ordenada/ inserida na tabela hash
        String linhaQtd = ler.readLine(); //Variavel para ler o que tem no "entrada.txt"
        int qtdOrd = Integer.parseInt(linhaQtd); //Conversão de String para inteiro do valor lido do arquivo "entrada.txt"
        Registro[] vetor = new Registro[qtdOrd]; //Vetor de Registros com o tamanho sendo o valor lido do arquivo "entrada.txt" que será ordenado/ inserido na tabela hash
        try {
            BufferedReader leitura = new BufferedReader(new FileReader("test.csv")); //Leitura do arquivo .csv de Registros
            String linha = leitura.readLine(); //Variavel que lê a primeira linha do arquivo .csv
            while (linha != null) {
//                        TRATAMENTO DE ENTRADA (,)
                String[] aCampos = linha.split(VIRGULA); //Vetor que armazena temporariamente cada campo lido do .csv          
                String[] aCamposTEMP = linha.split(VIRGULA,6); //Vetor Temporario para resolver o problema da virgula no comentario
                if (aCampos.length > 6) {
                    for(int x=3; x<aCampos.length-2; x++){
                        aCampos[3] = aCampos[3] + aCampos[x];//Concatena todos os campos do comentario
                    }
                    aCampos[4] = aCampos[aCampos.length-2];//Coloca o ID do jogo na posição certa do vetor
                    aCampos[5] = aCampos[aCampos.length-1];//Coloca o Nome do jogo na posição certa do vetor
                    
                    for (int x = 0; x < 6; x++) {
                        aCamposTEMP[x] = aCampos[x];//Insere os campos num Vetor temporario
                    }
                    Registro r1 = new Registro(Integer.parseInt(aCamposTEMP[0]), aCamposTEMP[1], Float.parseFloat(aCamposTEMP[2]), aCamposTEMP[3], aCamposTEMP[4], aCamposTEMP[5]); //Cria um novo registro com os campos lidos do .csv
                    rw[i] = r1; // adiciona o novo registro criado no vetor contendo todos os registros
                    i++; //incrementa a variavel de controle
                }
                else if (aCampos.length == 6) { //Se tem tamanho 5 é porque o Registro está completo
                    Registro r1 = new Registro(Integer.parseInt(aCampos[0]), aCampos[1], Float.parseFloat(aCampos[2]), aCampos[3], aCampos[4], aCampos[5]); //Cria um novo registro com os campos lidos do .csv
                    rw[i] = r1; // adiciona o novo registro criado no vetor contendo todos os registros
                    i++; //incrementa a variavel de controle
                }

                linha = leitura.readLine(); //lê a proxima linha
            }
            while (j < qtdOrd ) { //Gera o vetor que será ordenado/ inserido na tabela hash
                int aleatorio = r.nextInt(68); //Gera um valor aleatório entre 0 e a quantidade de registros - 1
                vetor[j] = rw[aleatorio]; //insere no vetor o valor aleatorio corresponde no vetor que contem todos os registros criados
                j++; // incrementa a variavel de controle
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro na leitura do arquivo."); //mensagem de erro caso não seja possivel realizar a leitura do arquivo
        }
        return vetor; // retorno para a funcao Main 
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Random r = new Random();
        Registro[] vetor = lerArquivo();
        
        //Faz a ordenacao usando o InsertionSort e salva em um .txt de saida com as métricas de desempenho
//                System.out.println("insertion");
                InsertionSort insertion = new InsertionSort(vetor);
                insertion.Organiza();

        //Faz a ordenacao usando o HeapSort e salva em um .txt de saida com as métricas de desempenho
//                HeapSort heap = new HeapSort(vetor);
//                heap.Organiza();

        //Faz a ordenacao usando o MergeSort e salva em um .txt de saida com as métricas de desempenho
//                MergeSort merge = new MergeSort(vetor);
//                merge.Organiza();

        //Faz a ordenacao usando o QuickSort com o pivo sendo a mediana e salva em um .txt de saida com as métricas de desempenho
//                QuickSortMed quick = new QuickSortMed(vetor);
//                quick.Organiza();
//                Da erro de ordenação quando quer, ANALISAR
          
        //Faz a ordenacao usando o QuickSort recursivo e salva em um .txt de saida com as métricas de desempenho
//                QuickSortRec quick = new QuickSortRec(vetor);
//                quick.Organiza();


        //Faz a ordenacao usando o QuickSort recursivo ou usando o InsertionSort, dependendo do número de chaves no vetor e salva em um .txt de saida com as métricas de desempenho
//            System.out.println("Digite um valor inteiro para M: ");
//            Scanner ler = new Scanner(System.in);
//            int m = Integer.parseInt(ler.nextLine());
//            QuickSortIns quick = new QuickSortIns(vetor);
//            quick.Organiza(m);
//          FUNCIONA ATÉ COM M = TAMANHO DO VETOR - 1, SE M >= TAMANHO DO VETOR FAZ A ORDENAÇÃO BUGADA
//          TEM QUE AJUSTAR OS CONTADORES DE COMPARAÇÕES E DE CÓPIAS DE REGISTRO (COMP E CONT)

        //Faz o tratamento de colisoes usando a sondagem linear
//SondagemLinear hash = new SondagemLinear(vetor.length);
//            for(int i=0;i<vetor.length;i++){
//                int a = vetor[i].id;
//                hash.insere(a);
//            }	
//            hash.imprimeTabelaHash();

        //Faz o tratamento de colisoes usando a sondagem quadratica
//        SondagemQuadratica hash = new SondagemQuadratica(vetor.length);
//        for (int i = 0; i < vetor.length; i++) {
//            int a = vetor[i].id;
//            hash.insere(a);
//        }
//        hash.imprimeTabelaHash();
//
//            //Encadeamento Separado
//            EncadSep l1 = new EncadSep(vetor);
//            for(int i=0;i<vetor.length;i++){
//                l1.insere(vetor[i]);
//            }
//            l1.Imprime();
        
    }
}
