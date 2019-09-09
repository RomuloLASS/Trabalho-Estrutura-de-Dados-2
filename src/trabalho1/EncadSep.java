package trabalho1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EncadSep {

    private int[] Lista;
    private NoES[] ListaEncad;
    private int comp = 0;

    public EncadSep(Registro[] L1) throws IOException {
        Lista = new int[L1.length];
        ListaEncad = new NoES[L1.length];
        long tempoInicial = System.currentTimeMillis();
        for (Registro L11 : L1) {
            insere(L11);
        }
        long tempoFinal = System.currentTimeMillis();
        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");
        System.out.println("O numero de comparações é " + comp);
        
        //Referencia o arquivo na pasta
        File arquivo = new File("saida.txt");

        //Se o arquivo nao existir na pasta, ele cria
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        //Escreve e fecha arquivo
        try ( //Prepara para escrever no arquivo criado
                BufferedWriter saida = new BufferedWriter(new FileWriter(arquivo.getAbsoluteFile()))) {
            //Escreve e fecha arquivo
            saida.write("Numero de comparações: " + comp + "\r\nTempo de execução: " + (tempoFinal - tempoInicial) + " ms");
        }
    }

    protected void insere(Registro t) {
        if (Lista[t.getId() % Lista.length] == -1) {
            Lista[t.getId() % Lista.length] = t.getId();
        } else if (Lista[t.getId() % Lista.length] != t.getId()) {
            comp++;
            if (ListaEncad[t.getId() % Lista.length] == null) {
                ListaEncad[t.getId() % Lista.length] = new NoES(t);
            } else {
                NoES n = ListaEncad[t.getId() % Lista.length];
                while (n.getProx() != null) {
                    comp += 2;
                    if (n.getRegistro() == t) {
                        break;
                    }
                    n = n.getProx();
                }
                if (n.getRegistro() != t) {
                    n.setProx(new NoES(t));
                }
                comp++;
            }
            comp++;
        }
        comp++;
    }

    protected void Imprime() {
        int i=0;
        while(i<Lista.length){
            System.out.print(Lista[i] + "   ");
            if (ListaEncad[i] != null) {
                ImprimeEncad(ListaEncad[i]);
            }
            System.out.println("");
            i++;
        }
//        if (i < Lista.length) {
//            System.out.print(Lista[i] + "   ");
//            if (ListaEncad[i] != null) {
//                ImprimeEncad(ListaEncad[i]);
//            }
//            System.out.println("");
//            this.Imprime(i++);
//        } 
    }

    protected void ImprimeEncad(NoES n) {
        System.out.print(n.getRegistro().getId() + "    ");
        if (n.getProx() != null) {
            this.ImprimeEncad(n.getProx());
        }
    }
}
