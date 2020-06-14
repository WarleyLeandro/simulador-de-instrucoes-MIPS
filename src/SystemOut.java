import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SystemOut {
    Memory men = new Memory();
    Register reg = new Register();
    // imprimir registradores


    // imprimir memoria
    public void imprimeMemoria() throws IOException {
        ArrayList<Memory> lista = new ArrayList<Memory>();
        lista = men.imprimeMemoria();
        
        FileWriter arq = new FileWriter("c:\\memory.out.txt");
        PrintWriter gravar = new PrintWriter(arq);
 
        
        for (int i=0; i<=lista.size(); i++) {
            Memory temp = lista.get(i);
            gravar.printf(temp.endereco + " " + temp.instrucao + " " + temp.dados);
        }
        arq.close();
    }

    //imprime registradores
    public void imprimeRegistrador() throws IOException {
        ArrayList<Register> lista = new ArrayList<Register>();
        lista = reg.imprimeRegistradores();
        
        //colocar escrever de arquivos
        FileWriter arq = new FileWriter("c:\\register.out.txt");
        PrintWriter gravar = new PrintWriter(arq);
 
        for (int i=0; i<=lista.size(); i++) {
            Register temp = lista.get(i);
            gravar.printf(temp.nome + " " + temp.instrucao + " " + temp.localDate);
        }
        arq.close();
    }

}