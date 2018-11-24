import java.util.LinkedHashMap;

public class Instruction_Format{

	LinkedHashMap<String,Integer> instruction_Format;
	public Instruction_Format() {
		instruction_Format = new LinkedHashMap<String, Integer>();
		instruction_Format_Put();
	}
	
	public void instruction_Format_Put() {
		instruction_Format.put("ADD", 3);
		instruction_Format.put("ADDF", 3);
		instruction_Format.put("ADDR", 2);
		instruction_Format.put("AND", 3);
		instruction_Format.put("CLEAR", 2);
		instruction_Format.put("COMP", 3);
		instruction_Format.put("COMPF", 3);
		instruction_Format.put("COMPR", 2);
		instruction_Format.put("DIV", 3);
		instruction_Format.put("DIVF", 3);
		instruction_Format.put("DIVR", 2);
		instruction_Format.put("FIX", 1);
		instruction_Format.put("FLOAT", 1);
		instruction_Format.put("HIO", 1);
		instruction_Format.put("J", 3);
		instruction_Format.put("JEQ", 3);
		instruction_Format.put("JGT", 3);
		instruction_Format.put("JLT", 3);
		instruction_Format.put("JSUB", 3);
		instruction_Format.put("LDA", 3);
		instruction_Format.put("LDB", 3);
		instruction_Format.put("LDCH", 3);
		instruction_Format.put("LDF", 3);
		instruction_Format.put("LDL", 3);
		instruction_Format.put("LDS", 3);
		instruction_Format.put("LDT", 3);
		instruction_Format.put("LDX", 3);
		instruction_Format.put("LPS", 3);
		instruction_Format.put("MUL",3);
		instruction_Format.put("MULF", 3);
		instruction_Format.put("MULR", 2);
		instruction_Format.put("NORM", 1);
		instruction_Format.put("OR", 3);
		instruction_Format.put("RD",3);
		instruction_Format.put("RMO",2);
		instruction_Format.put("RSUB", 3);
		instruction_Format.put("SHIFTL", 2);
		instruction_Format.put("SHIFTR", 2);
		instruction_Format.put("SIO", 1);
		instruction_Format.put("SSK", 3);
		instruction_Format.put("STA", 3);
		instruction_Format.put("STB", 3);
		instruction_Format.put("STCH", 3);
		instruction_Format.put("STF", 3);
		instruction_Format.put("STI", 3);
		instruction_Format.put("STL", 3);
		instruction_Format.put("STS", 3);
		instruction_Format.put("STSW", 3);
		instruction_Format.put("STT", 3);
		instruction_Format.put("STX", 3);
		instruction_Format.put("SUB",3);
		instruction_Format.put("SUBF", 3);
		instruction_Format.put("SUBR", 2);
		instruction_Format.put("SVC", 2);
		instruction_Format.put("TD", 3);
		instruction_Format.put("TIO", 1);
		instruction_Format.put("TIX", 3);
		instruction_Format.put("TIXR", 2);
		instruction_Format.put("WD",3);
	}
	
	public LinkedHashMap<String, Integer> getMap() {
		return instruction_Format;
	}

}
