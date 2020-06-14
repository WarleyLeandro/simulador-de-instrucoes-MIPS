import java.util.ArrayList;

public class Memory {

    public String endereco;
    public String instrucao;
    public String dados;
    ArrayList<Memory> memory = new ArrayList<Memory>();

    // salva o dado e instrução na memoria
    public void salvaDados(String endereco, String instrucao, String dados) {
        Memory men = new Memory();
        if(instrucao == " ") {
            men.instrucao = null;
            men.endereco = endereco;
            men.dados = dados;
            memory.add(men); 
        } else if(dados == " ") {
           men.endereco = endereco;
            men.instrucao = instrucao;
            men.dados = null;
            memory.add(men); 
        } else {
            System.out.println("Dados inválidos!");        
        }

    }

    // carrega a instrução da memória
    public String carregaInstrucao(String buscaEnd) {
        for (int i = 0; i < memory.size(); i++) {
            Memory temp = memory.get(i);
            if (temp.endereco == buscaEnd) {
                return temp.instrucao;
            }
        }
        return "Instrução não encontrada na memória";
    }

    // carrega o dado da memória
    public String carregaDados(String buscaEnd) {
        for (int i = 0; i < memory.size(); i++) {
            Memory temp = memory.get(i);
            if (temp.endereco == buscaEnd) {
                return temp.dados;
            }
        }
        return "Dado não encontrado na memória";
    }

    // gera todos endereços de 32
    public String geraEndereco(int indice) {
        String[] enderecos = { "0x000", "0x001", "0x002", "0x003", "0x004", "0x005", "0x006", "0x007", "0x008", "0x009",
                "0x010", "0x011", "0x012", "0x013", "0x014", "0x015", "0x016", "0x017", "0x0018", "0x0019", "0x020",
                "0x021", "0x022", "0x023", "0x024", "0x025", "0x026", "0x027", "0x028", "0x029", "0x030", "0x031" };
        return enderecos[indice];
    }

    // imprimir arquivo
    public ArrayList<Memory> imprimeMemoria() {
      return memory;
    }

}