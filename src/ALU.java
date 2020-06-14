public class ALU {
    public static final short ADD = 0;
    public static final short SUB = 1;
    public static final short MULT = 2;
    public static final short DIV = 3;
    public static final short AND = 4;
    public static final short OR = 5;
    public static final short XOR = 6;
    public static final short NOR = 7;
    public static final short SLT = 8;
    public static final short SLL = 9;
    public static final short SRL = 11;
    public static final short JR = 12;
    public static final short ADDI = 13;
    public static final short ANDI = 14;
    public static final short ORI = 15;
    public static final short SLTI = 16;
    public static final short BEQ = 17;
    public static final short LW = 18;
    public static final short SW = 19;
    public static final short J = 20;
    public static final short JAL = 21;     

    public String getInstrucao(int indice) {
        String[] name = { "ADD", "SUB", "MULT", "DIV", "AND", "OR", "XOR", "NOR", "SLT", "SLL", "SRL", "JR", "ADDI", "ANDI", "ORI", "SLTI", "BEQ", "LW", "SW", "J", "JAL" };
        return name[indice];
    }

}