import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Program {
	
	private static Scanner scanner;
	
	public static String checkRemove (String brackets) {
		brackets=brackets.replaceAll("\\(", " ").replaceAll("\\)","");;
		return brackets;
	}
	
	public static void escreve(String instruc, String regist1, String regist2, String regist3 ){
	    try {

	    	FileWriter resultado = new FileWriter("c:\\resultado.txt");
	    	PrintWriter gravaArq = new PrintWriter(resultado);
	    	
	    	gravaArq.printf(instruc);
	    	gravaArq.close();
	    	
	    	
	    }catch(IOException e){
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}
	
	public static void  RegisterTypeR (String opcode, String rs, String rt, String rd, String shamt, String funct) {
		if (!Decode.getRegister3().equals("0")) {
				System.out.println("----------------------------------------------------");
				System.out.println(Decode.getInstruction()+" " + Decode.getRegister1()+", "+ Decode.getRegister2()+", "+ Decode.getRegister3()+"\n");
				System.out.println(opcode+""+rs+""+rt+""+rd+""+shamt+""+funct);
				System.out.println("----------------------------------------------------");	
		}
		else {
			System.out.println("----------------------------------------------------");
			System.out.println(Decode.getInstruction()+" " + Decode.getRegister1()+", "+ Decode.getRegister2()+" \n");
			System.out.println(opcode+""+rs+""+rt+""+rd+""+shamt+""+funct);
			System.out.println("----------------------------------------------------");	
		}
	}
		
		
	public static void RegisterTypeI (String opcode, String rs, String rt, String immediate) {
		
		if (!Decode.getRegister3().equals("0")) {
			if((opcode.equals("100011"))||(opcode.equals("101011"))){
				System.out.println("----------------------------------------------------");
				System.out.println(Decode.getInstruction()+" " + Decode.getRegister1()+", "+ Decode.getRegister2()+"("+Decode.getRegister3()+") \n");
				System.out.println(opcode+""+rs+""+rt+""+immediate);
				System.out.println("----------------------------------------------------");	
			}
			else {
				System.out.println("----------------------------------------------------");
				System.out.println(Decode.getInstruction()+" " + Decode.getRegister1()+", "+ Decode.getRegister2()+", "+ Decode.getRegister3()+"\n");
				System.out.println(opcode+""+rs+""+rt+""+immediate);
				System.out.println("----------------------------------------------------");	
			}
		}
		else {
			
			System.out.println("----------------------------------------------------");
			System.out.println(Decode.getInstruction()+" " + Decode.getRegister1()+", "+ Decode.getRegister2()+" \n");
			System.out.println(opcode+""+rs+""+rt+""+immediate);
			System.out.println("----------------------------------------------------");	
		}
	}
		
	public static void  RegisterTypeJ (String opcode, String address) {
		
			System.out.println("----------------------------------------------------");
			System.out.println(Decode.getInstruction()+" " + Decode.getRegister1()+"\n");
			System.out.println(opcode+""+address);
			System.out.println("----------------------------------------------------");	
	}
	
	public static void main(String[] args) throws IOException {
		String line=null;
		String[] instruction = new String[4];
		System.out.print("Olá, seja Bem-Vindo ao MIPS32-Decode \n 1- Digitar a instrução \n 2- Usar um arquivo do computador \n");
		
		System.out.print("Qual a opção que deseja selecionar -> ");
		scanner = new Scanner(System.in);
		int menu = scanner.nextInt();
		
		switch (menu) {
			case 1:
				System.out.print("Digite a instrução: ");
				scanner = new Scanner(System.in);
				String core = scanner.nextLine();
				
				instruction= core.split(" ");
				for(int i=0; i < instruction.length; i++) {
					if(i==0) {
						Decode.setInstruction(instruction[i]);
					}
					else if(i==1) {
						Decode.setRegister1(Decode.removeComma(instruction[i]));
					}
					else if (i==2) {
						String comma = Decode.removeComma(instruction[i]);
						comma=checkRemove(comma);
						if(comma.contains(" ")) {
							String[] separate	= comma.split(" ");
							Decode.setRegister2((Decode.removeComma(separate[0])));
							Decode.setRegister3((Decode.removeComma(separate[1])));
						}
						else {
							Decode.setRegister2((Decode.removeComma(instruction[i])));
							Decode.setRegister3("0");
						}
					}
					else if (i==3){
						Decode.setRegister3((Decode.removeComma(instruction[3])));
					}
				}
				
				Decode.decode(Decode.getInstruction(), Decode.getRegister1(), Decode.getRegister2(), Decode.getRegister3());
				
				break;
				
			case 2:
				System.out.print("Digite o endereço aonde está localizado o arquivo: ");
				scanner = new Scanner(System.in);
				String address = scanner.nextLine();
				try {
					BufferedReader ler = Files.newBufferedReader(Paths.get(address));
					while ((line = ler.readLine()) != null) {
						instruction= line.split(" ");
						for(int i=0; i < instruction.length; i++) {
							if(i==0) {
								Decode.setInstruction(instruction[i]);
							}
							else if(i==1) {
								Decode.setRegister1(Decode.removeComma(instruction[i]));
							}
							else if (i==2) {
								String comma = Decode.removeComma(instruction[i]);
								comma=checkRemove(comma);
								if(comma.contains(" ")) {
									String[] separate	= comma.split(" ");
									Decode.setRegister2((Decode.removeComma(separate[0])));
									Decode.setRegister3((Decode.removeComma(separate[1])));
								}
								else {
									Decode.setRegister2((Decode.removeComma(instruction[i])));
									Decode.setRegister3("0");
								}
							}
							else if (i==3){
								Decode.setRegister3((Decode.removeComma(instruction[3])));
							}
						}
						
						Decode.decode(Decode.getInstruction(), Decode.getRegister1(), Decode.getRegister2(), Decode.getRegister3());
						
					}
						ler.close();
					}catch(IOException e){
						System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
					}
				break;
				
			default:
				System.out.println("Essa escolha não existe, por favor escolher uma nova escolha");
				break;
		}
		
	}
}
