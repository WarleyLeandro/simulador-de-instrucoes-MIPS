
 
public class Decode {
	
	private static String instruction = null;
	private static String register1 = null;
	private static String register2 = null;
	private static String register3 = null;
	
	//Container
	
	public Decode() {
		
	}
	
	public Decode (String instruction, String register1, String register2) {
		   
        Decode.instruction = instruction;
        Decode.register1 = register1;
        Decode.register2 = register2;
    }
	
	public Decode (String instruction, String register1, String register2, String register3) {
		   
        Decode.instruction = instruction;
        Decode.register1 = register1;
        Decode.register2 = register2;
        Decode.register3 = register3;
    }
	
	//get and setters
	
	public static String getInstruction() {
		return instruction;
	}

	public static void setInstruction(String instruction) {
		Decode.instruction = instruction;
	}

	public static String getRegister1() {
		return register1;
	}

	public static void setRegister1(String register1) {
		Decode.register1 = register1;
	}

	public static String getRegister2() {
		return register2;
	}

	public static void setRegister2(String register2) {
		Decode.register2 = register2;
	}

	public static String getRegister3() {
		return register3;
	}

	public static void setRegister3(String register3) {
		Decode.register3 = register3;
	}

	//Remove all the commas after the split with Scanner
	
	public static String removeComma (String register) {
		String comma = register.replaceFirst(",", "");
		return comma;
	}
	
	
	//Finding whats the opcode, funct and format of the core intruction set
	
	public static void decode (String instruction, String registro1, String registro2, String registro3){
		
		String opcode=null;
		String funct=null;
		String shamt=null;
		
		
		switch(instruction.toLowerCase()){ 
		/*INICIO DAS INSTRUCOES ARITMETICAS*/
            case "add": 
            	
            	opcode = "000000";
            	funct= "100000";
            	shamt= "00000";
            	
            	Program.RegisterTypeR(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro3), Decode.registerNumber(registro1), shamt, funct);
            	
    			break;
    			
            case "addi": 
            	opcode = "001000";
            	
            	Program.RegisterTypeI(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro1), Decode.immediateChanger(Decode.convertToBinary(registro3)));
            	
                break; 
                
            case "sub": 
                opcode = "000000"; 
                funct= "100010"; 
            	shamt= "00000";
            	
            	Program.RegisterTypeR(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro3), Decode.registerNumber(registro1), shamt, funct);
            	
            	
                break; 
                
            case "mult": 
                opcode = "000000";
                funct= "011000"; 
                shamt="00000";
            	
                Program.RegisterTypeR(opcode, Decode.registerNumber(registro1), Decode.registerNumber(registro2),"00000",shamt, funct);
            	
                break; 
                
            case "div": 
                opcode = "000000";
            	funct= "011010";
                shamt="00000";
                
                Program.RegisterTypeR(opcode, Decode.registerNumber(registro1), Decode.registerNumber(registro2),"00000",shamt, funct);
                break;
                
            case "neg": 
                opcode = "000000";
            	funct= "000111"; 
            	shamt= "00000";
            	
            	Program.RegisterTypeR(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro3), Decode.registerNumber(registro1), shamt, funct);
                break; 
                
                /*FIM DAS INSTRUCOES ARITMETICAS*/
                /*INICIO DAS INSTRUCOES LOGICAS*/

            case "and": 
                opcode = "000000";
            	funct= "100100"; 
            	shamt= "00000";
            	
            	Program.RegisterTypeR(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro3), Decode.registerNumber(registro1), shamt, funct);
            	
                break; 
                
            case "andi": 
                opcode = "001100";
            
                Program.RegisterTypeI(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro1), Decode.immediateChanger(Decode.convertToBinary(registro3)));
                break;
                
            case "or": 
                opcode = "000000";
            	funct= "100101"; 
            	shamt= "00000";
            	
            	Program.RegisterTypeR(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro3), Decode.registerNumber(registro1), shamt, funct);
                break;
                
            case "ori": 
                opcode = "001101";
                
                Program.RegisterTypeI(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro1), Decode.immediateChanger(Decode.convertToBinary(registro3)));
                break; 
                
            case "xor": 
                opcode = "000000";
            	funct= "100110"; 
            	shamt= "00000";
            	
            	Program.RegisterTypeR(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro3), Decode.registerNumber(registro1), shamt, funct);
                break; 
                
            case "nor": 
                opcode = "000000"; 
            	funct= "100111"; 
            	shamt= "00000";
            	
            	Program.RegisterTypeR(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro3), Decode.registerNumber(registro1), shamt, funct);
                break; 
                
            case "slt": 
                opcode = "000000"; 
            	funct= "101010"; 
            	shamt= "00000";
            	
            	
            	Program.RegisterTypeR(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro3), Decode.registerNumber(registro1), shamt, funct);
                break; 
                
            case "slti": 
                opcode = "001011";
            	
            	Program.RegisterTypeI(opcode, Decode.registerNumber(registro2), Decode.registerNumber(registro1), Decode.immediateChanger(Decode.convertToBinary(registro3)));
            	
                break; 
                
                /*FIM DAS INSTRUCOES LOGICAS*/
                /*INICIO DAS INSTRUCOES DESLOCAMENTO*/
                
            case "sll": 
                opcode = "000000";
            	funct= "000000"; 
            	shamt= Decode.convertToBinary(registro3);
            	
            	Program.RegisterTypeR(opcode, "00000", Decode.registerNumber(registro2), Decode.registerNumber(registro1), shamt, funct);
            	
                break; 
                
            case "srl": 
                opcode = "000000";
            	funct= "000000"; 
            	shamt= Decode.convertToBinary(registro3);
            	
            	Program.RegisterTypeR(opcode, "00000", Decode.registerNumber(registro2), Decode.registerNumber(registro1), shamt, funct);
            	
                break; 
                
                /*FIM DAS INSTRUCOES DESLOCAMENTO*/
                /*INICIO DAS INSTRUCOES ACESSO MEM*/
                
            case "lw": 
                opcode = "100011";
            	
                Program.RegisterTypeI(opcode, Decode.registerNumber(registro3), Decode.registerNumber(registro1), Decode.immediateChanger(Decode.convertToBinary(registro2)));
            	
                break; 
                
            case "sw": 
                opcode = "101011"; 
            	
                Program.RegisterTypeI(opcode, Decode.registerNumber(registro3), Decode.registerNumber(registro1), Decode.immediateChanger(Decode.convertToBinary(registro2)));
            	
                break; 
                
                /*FIM DAS INSTRUCOES ACESSO MEM*/
                /*INICIO DAS INSTRUCOES DESVIO COND*/
            case "beq": 
                opcode = "000100";
            	
                Program.RegisterTypeI(opcode, Decode.registerNumber(registro1), Decode.registerNumber(registro2), Decode.immediateChanger(Decode.convertToBinary(registro3)));
            	
                break; 
                
            case "bne": 
                opcode = "000101"; 
                
                Program.RegisterTypeI(opcode, Decode.registerNumber(registro1), Decode.registerNumber(registro2), Decode.immediateChanger(Decode.convertToBinary(registro3)));
                break;
                
                /*FIM DAS INSTRUCOES DESVIO COND*/
                /*INICIO DAS INSTRUCOES DESVIO INCOND*/
                
            case "j": 
                opcode = "000010"; 
                
                Program.RegisterTypeJ(opcode, Decode.addressChanger(Decode.convertToBinary(registro1)));
                
                break; 
                
            case "jr": 
                opcode = "000000";
            	funct= "001000"; 
            	shamt= "00000";
            	
            	Program.RegisterTypeR(opcode, Decode.registerNumber(registro1),"00000", "00000", shamt, funct);
            	
                break; 
                
            case "jal": 
                opcode = "000011";
                
                Program.RegisterTypeJ(opcode, Decode.addressChanger(Decode.convertToBinary(registro1)));
               
                break; 
                
                /*FIM DAS INSTRUCOES DESVIO COND*/
                /*OUTRAS*/
                
            case "nop": 
                opcode = "000000";
            	funct= "000000";
            	shamt= "00000";
            	
            	Program.RegisterTypeR(opcode, "00000", "00000", "00000", shamt, funct);
            	
                break; 
                
            default: 
                System.out.println("instrução nao conhecida");
                } 
        } 
	
	public static String addressChanger(String address) {
			int number = Integer.parseInt(address);
			address =	String.format("%026d" , number);
			return address;
	}
	
	public static String immediateChanger(String immediate) {
			int number = Integer.parseInt(immediate);
			immediate =	String.format("%016d" , number);
			return immediate;
	}

	public static String registerNumber (String registerNumber) {
		String sign = registerNumber.replaceFirst("$", "");
		switch(sign.toLowerCase()){ 
		
            case "zero":
            	registerNumber="00000";
            	
            	return registerNumber;
            	
            case "at":
            	registerNumber="00001";
            	
            	return registerNumber;
            	
            case "v0":
            	registerNumber="00010";
            	
            	return registerNumber;
            	
            case "v1":
            	registerNumber="00011";
            	
            	return registerNumber;
            	
            case "a0":
            	registerNumber="00100";
            	
            	return registerNumber;
            
            case "a1":
            	registerNumber="00101";
            	
            	return registerNumber;
            	
            case "a2":
            	registerNumber="00110";
            	
            	return registerNumber;
            
            case "a3":
            	registerNumber="00111";
            	
            	return registerNumber;
            	
            case "t0":
            	registerNumber="01000";
            	
            	return registerNumber;
            
            case "t1":
            	registerNumber="01001";
            	
            	return registerNumber;
            	
            case "t2":
            	registerNumber="01010";
            	
            	return registerNumber;
            	
            case "t3":
            	registerNumber="01011";
            	
            	return registerNumber;
            
            case "t4":
            	registerNumber="01100";
            	
            	return registerNumber;
            	
            case "t5":
            	registerNumber="01101";
            	
            	return registerNumber;
            
            case "t6":
            	registerNumber="01110";
            	
            	return registerNumber;
            
            case "t7":
            	registerNumber="01111";
            	
            	return registerNumber;
            	
            case "s0":
            	registerNumber="10000";
            	
            	return registerNumber;
            
            case "s1":
            	registerNumber="10001";
            	
            	return registerNumber;
            	
            case "s2":
            	registerNumber="10010";
            	
            	return registerNumber;
            	
            case "s3":
            	registerNumber="10011";
            	
            	return registerNumber;
            
            case "s4":
            	registerNumber="10100";
            	
            	return registerNumber;
            	
            case "s5":
            	registerNumber="10101";
            	
            	return registerNumber;
            
            case "s6":
            	registerNumber="10110";
            	
            	return registerNumber;
            
            case "s7":
            	registerNumber="10111";
            	
            	return registerNumber;
            	
            case "t8":
            	registerNumber="11000";
            	
            	return registerNumber;
            
            case "t9":
            	registerNumber="11001";
            	
            	return registerNumber;
            	
            case "k0":
            	registerNumber="11010";
            	
            	return registerNumber;
            
            case "k1":
            	registerNumber="11011";
            	
            	return registerNumber;
            	
            case "gp":
            	registerNumber="11100";
            	
            	return registerNumber;
            
            case "sp":
            	registerNumber="11101";
            	
            	return registerNumber;
            
            case "fp":
            	registerNumber="11110";
            	
            	return registerNumber;
            
            case "ra":
            	registerNumber="11111";
            	
            	return registerNumber;
                
            default: 
                System.out.println("Esse nome de registro não existe");
                break;
                }
		return registerNumber;
	}
	
	public static String convertToBinary (String hex) {
		
		hex = hex.replaceAll("0", "0000");
        hex = hex.replaceAll("1", "0001");
        hex = hex.replaceAll("2", "0010");
        hex = hex.replaceAll("3", "0011");
        hex = hex.replaceAll("4", "0100");
        hex = hex.replaceAll("5", "0101");
        hex = hex.replaceAll("6", "0110");
        hex = hex.replaceAll("7", "0111");
        hex = hex.replaceAll("8", "1000");
        hex = hex.replaceAll("9", "1001");
        hex = hex.replaceAll("A", "1010").replaceAll("a","1010");
        hex = hex.replaceAll("B", "1011").replaceAll("b","1011");
        hex = hex.replaceAll("C", "1100").replaceAll("c","1100");
        hex = hex.replaceAll("D", "1101").replaceAll("d","1101");
        hex = hex.replaceAll("E", "1110").replaceAll("e","1110");
        hex = hex.replaceAll("F", "1111").replaceAll("f","1111");
        
        return hex;
	}

}
