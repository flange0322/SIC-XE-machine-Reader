import java.util.LinkedHashMap;

//«ü¥O®w
public class Instruction_Op extends data_Library{
	LinkedHashMap<String,String> instruction_Opcodes;
	public Instruction_Op() {
		instruction_Opcodes = new LinkedHashMap<String, String>();
		instruction_Op_Put();
	}
	public void instruction_Op_Put() {
		instruction_Opcodes.put("ADD", "18");
		instruction_Opcodes.put("ADDF", "58");
		instruction_Opcodes.put("ADDR", "90");
		instruction_Opcodes.put("AND", "40");
		instruction_Opcodes.put("CLEAR", "B4");
		instruction_Opcodes.put("COMP", "28");
		instruction_Opcodes.put("COMPF", "88");
		instruction_Opcodes.put("COMPR", "A0");
		instruction_Opcodes.put("DIV", "24");
		instruction_Opcodes.put("DIVF", "64");
		instruction_Opcodes.put("DIVR", "9C");
		instruction_Opcodes.put("FIX", "C4");
		instruction_Opcodes.put("FLOAT", "C0");
		instruction_Opcodes.put("HIO", "F4");
		instruction_Opcodes.put("J", "3C");
		instruction_Opcodes.put("JEQ", "30");
		instruction_Opcodes.put("JGT", "34");
		instruction_Opcodes.put("JLT", "38");
		instruction_Opcodes.put("JSUB", "48");
		instruction_Opcodes.put("LDA", "00");
		instruction_Opcodes.put("LDB", "68");
		instruction_Opcodes.put("LDCH", "50");
		instruction_Opcodes.put("LDF", "70");
		instruction_Opcodes.put("LDL", "08");
		instruction_Opcodes.put("LDS", "6C");
		instruction_Opcodes.put("LDT", "74");
		instruction_Opcodes.put("LDX", "04");
		instruction_Opcodes.put("LPS", "D0");
		instruction_Opcodes.put("MUL", "20");
		instruction_Opcodes.put("MULF", "60");
		instruction_Opcodes.put("MULR", "98");
		instruction_Opcodes.put("NORM", "C8");
		instruction_Opcodes.put("OR", "44");
		instruction_Opcodes.put("RD", "D8");
		instruction_Opcodes.put("RMO", "AC");
		instruction_Opcodes.put("RSUB", "4C");
		instruction_Opcodes.put("SHIFTL", "A4");
		instruction_Opcodes.put("SHIFTR", "A8");
		instruction_Opcodes.put("SIO", "F0");
		instruction_Opcodes.put("SSK", "EC");
		instruction_Opcodes.put("STA", "0C");
		instruction_Opcodes.put("STB", "78");
		instruction_Opcodes.put("STCH", "54");
		instruction_Opcodes.put("STF", "80");
		instruction_Opcodes.put("STI", "D4");
		instruction_Opcodes.put("STL", "14");
		instruction_Opcodes.put("STS", "7C");
		instruction_Opcodes.put("STSW", "E8");
		instruction_Opcodes.put("STT", "84");
		instruction_Opcodes.put("STX", "10");
		instruction_Opcodes.put("SUB", "1C");
		instruction_Opcodes.put("SUBF", "5C");
		instruction_Opcodes.put("SUBR", "94");
		instruction_Opcodes.put("SVC", "B0");
		instruction_Opcodes.put("TD", "E0");
		instruction_Opcodes.put("TIO", "F8");
		instruction_Opcodes.put("TIX", "2C");
		instruction_Opcodes.put("TIXR", "B8");
		instruction_Opcodes.put("WD", "DC");
		instruction_Opcodes.put("START","");
		instruction_Opcodes.put("END","");
		instruction_Opcodes.put("BYTE","");
		instruction_Opcodes.put("WORD","");
		instruction_Opcodes.put("RESW","");
		instruction_Opcodes.put("RESB","");
		instruction_Opcodes.put("BASE","");
	}

	public LinkedHashMap<String, String> getMap() {
		return instruction_Opcodes;
	}
}