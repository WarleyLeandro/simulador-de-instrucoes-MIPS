import java.util.ArrayList;
public class Register{
	ArrayList<Register> registradores = new ArrayList<Register>();
    //São 32 registradores
	public String nome;
	public String instrucao;
	public String localDate;

	public void salvaDados(String instrucao, String dados, int indice){
		Register reg = new Register();
		String registra = reg.name(indice);
		reg.nome = registra;
		if(instrucao == " ") {
            reg.instrucao = null;
            reg.localDate = dados;
            registradores.add(reg); 
        } else if(dados == " ") {
            reg.instrucao = instrucao;
            reg.localDate = null;
            registradores.add(reg); 
        } else {
            System.out.println("Dados inválidos!");        
        }
	}

	
	public void limpaDados(){
		for(int i = 0; i<=registradores.size(); i++){
			Register temp = registradores.get(i);
			temp.nome = " ";
			temp.localDate = " ";
			temp.localDate = " ";
		}
	}
	


    public static String name(int indice) {
		String[] name = {
				"$zero", 
				"$at",
				"$v0",
				"$v1",
				"$a0",
				"$a1",
				"$a2",
				"$a3",
				"$t0",
				"$t1",
				"$t2",
				"$t3",
				"$t4",
				"$t5",
				"$t6",
				"$t7",
				"$s0",
				"$s1",
				"$s2",
				"$s3",
				"$s4",
				"$s5",
				"$s6",
				"$s7",
				"$t8",
				"$t9",
				"$k0",
				"$k1",
				"$gp",
				"$sp",
				"$fp",
				"$ra"
		};
        return name[indice];
	}


	public ArrayList<Register> imprimeRegistradores() {

		return registradores;
	}
	
	
}
