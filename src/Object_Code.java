import java.util.ArrayList;
import java.util.LinkedHashMap;
public class Object_Code {

	//計算Object codes
	ArrayList<String> object_Codes;
	ArrayList<String> Loc;
	LinkedHashMap<String,String> instruction_Operator;
	LinkedHashMap<String,String> sign_Loc;
	LinkedHashMap<String,String> instruction_Opcodes;
	NIXBPE_judge nixbpe;
	NIXBPE_Cal nixbpe_cal;
	Instruction_Format IF;
	String Base_Operator;
	public Object_Code(LinkedHashMap<String,String> instruction_Operator,LinkedHashMap<String,String> sign_Loc,LinkedHashMap<String,String> instruction_Opcodes,ArrayList<String> Loc,String Base_Operator) {
		this.instruction_Operator = instruction_Operator;
		this.sign_Loc = sign_Loc;
		this.instruction_Opcodes = instruction_Opcodes;
		this.Loc = Loc;
		this.Base_Operator = Base_Operator;
		object_Codes = new ArrayList<String>();
		nixbpe = new NIXBPE_judge();
		nixbpe_cal = new NIXBPE_Cal();
		IF = new Instruction_Format();
		making();
	}
	
	public void making() {
		boolean inputdata = false;
		int start_Pos = 0;
		int end_Pos = 0;
		int Loc_count = 0;
		for(String instruction : instruction_Operator.keySet()) {
			Loc_count++;
			for(int i=0;i<instruction.length();i++) {
				if(instruction.charAt(i) == '.'){
					start_Pos = i+1;
					inputdata = true;
				}
				if(inputdata == true) {
					end_Pos = instruction.length();
					String indeX_word = "";
					//檢查運算元是否x = 1;
					for(int j=0;j<instruction_Operator.get(instruction).length();j++) {
						if(instruction_Operator.get(instruction).charAt(j) == ','){
							int end_Pos_x = j;
							indeX_word += instruction_Operator.get(instruction).substring(0, end_Pos_x);
						}
					}
					
					if(instruction.substring(start_Pos, end_Pos).equals("START")||instruction.substring(start_Pos, end_Pos).equals("END")||instruction.substring(start_Pos, end_Pos).equals("RESW")||instruction.substring(start_Pos, end_Pos).equals("RESB"))
						break;
					else if(instruction.substring(start_Pos, end_Pos).equals("RSUB")) {
						object_Codes.add("4F0000");
						break;
					}
					else if(instruction.substring(start_Pos, end_Pos).equals("BYTE")) {
						String Oper = instruction_Operator.get(instruction);
						String word = "";
						for(int j=1;j<Oper.length();j++) {
							if(Oper.charAt(0) == 'C') {
								if(Oper.charAt(j)!='\'')
									word = word+Oper.charAt(j);
							}
							else{
								if(Oper.charAt(j)!='\'')
									word = word+Oper.charAt(j);
							}
						}
						if(Oper.charAt(0) == 'C') {
							String tmp = "";
							for(int j = 0;j<word.length();j++) {
								char c = word.charAt(j);
								int c1 = (int)c;
								tmp = tmp + Integer.toHexString(c1).toUpperCase();
							}
							word = "";
							word = tmp;
						}
						object_Codes.add(word);
						break;
					}
					else if(instruction.substring(start_Pos, end_Pos).equals("WORD")) { 
						int Int_number = Integer.valueOf(instruction_Operator.get(instruction));
						String number = "";
						//正數處理
						if(Int_number>=0) {
							number = Integer.toHexString(Int_number);
						}
						//負數處理
						else {
							String check_length = Integer.toHexString(Int_number);
							if(check_length.length() < 6) {
								number = Integer.toHexString(Int_number);
							}
							else {
								number = Integer.toHexString(Int_number).substring(2);
							}
						}
						while(number.length() < 6) {
							if(number.length() != 6) {
								number = "0"+number;
							}
						}
						object_Codes.add(number.toUpperCase());
						break;
					}
					else if(instruction_Operator.get(instruction).equals(indeX_word+",X")) {
						String ins = "";
						for(int j=0;j<instruction.substring(start_Pos, end_Pos).length();j++) {
							if(instruction.substring(start_Pos, end_Pos).charAt(j) == '+') {
								ins = instruction.substring(start_Pos+1, end_Pos);
								break;
							}
							else {
								ins = instruction.substring(start_Pos, end_Pos);
								break;
							}
						}
						
						nixbpe.set_InsOpe(instruction.substring(start_Pos, end_Pos), indeX_word);
						nixbpe_cal.setNotation(nixbpe.judgeIn()+" "+nixbpe.judgeOp());
						nixbpe_cal.setFormat(instruction_Opcodes.get(ins));
						for(String Operator : sign_Loc.keySet()) {
							if(Operator.equals(Base_Operator)) {
								nixbpe_cal.setBaseOperator(sign_Loc.get(Operator));
								break;
							}
						}
						
						String Operator = indeX_word;
						String sign = sign_Loc.get(Operator);					
						
						nixbpe_cal.setOL(sign);
						nixbpe_cal.setPL(Loc.get(Loc_count));
								
						String message = nixbpe_cal.CalFormat();
						if(message.equals("again")) {
							nixbpe_cal.is_Base();
							message = nixbpe_cal.CalFormat();
							nixbpe_cal.is_Base();
						}
						
						String index_cal = Integer.toHexString(Integer.parseInt(message.substring(0, 3),16)+8).toUpperCase();
						object_Codes.add(index_cal+message.substring(3));
						break;
					}
					else{
						String ins = "";
						boolean format_Four = false;
						for(int j=0;j<instruction.substring(start_Pos, end_Pos).length();j++) {
							if(instruction.substring(start_Pos, end_Pos).charAt(j) == '+') {
								ins = instruction.substring(start_Pos+1, end_Pos);
								format_Four = true;
								break;
							}
							else {
								ins = instruction.substring(start_Pos, end_Pos);
								break;
							}
						}
						
						int formatNumber = 0;
						for(String Format : IF.getMap().keySet()) {
							if(Format.equals(ins)) {
								formatNumber = IF.getMap().get(Format);
							}
						}
						
						nixbpe.set_InsOpe(instruction.substring(start_Pos, end_Pos), instruction_Operator.get(instruction));
						nixbpe_cal.setNotation(nixbpe.judgeIn()+" "+nixbpe.judgeOp());
						nixbpe_cal.setFormat(instruction_Opcodes.get(ins));
						for(String Operator : sign_Loc.keySet()) {
							if(Operator.equals(Base_Operator)) {
								nixbpe_cal.setBaseOperator(sign_Loc.get(Operator));
								break;
							}
						}
						
						String sign = null;
						String Operator = null;
						for(int j=0;j<instruction_Operator.get(instruction).length();j++) {
							if(instruction_Operator.get(instruction).charAt(j)=='#'||instruction_Operator.get(instruction).charAt(j)=='@') {
								Operator = instruction_Operator.get(instruction).substring(1);
								sign = sign_Loc.get(Operator);
								break;
							}
							else {
								Operator = instruction_Operator.get(instruction);
								sign = sign_Loc.get(Operator);
								break;
							}
						}
						
						if(formatNumber == 3 && format_Four == false) 
						{
							if(!(nixbpe.judgeIn()+" "+nixbpe.judgeOp()).equals("op #c")) {
					
								nixbpe_cal.setOL(sign);
								nixbpe_cal.setPL(Loc.get(Loc_count));
									
								String message = nixbpe_cal.CalFormat();
								if(message.equals("again")) {
									nixbpe_cal.is_Base();
									message = nixbpe_cal.CalFormat();
									nixbpe_cal.is_Base();
								}
								object_Codes.add(message);
							}
							else {
								String temp = Integer.toHexString(Integer.valueOf(Operator));
								while(temp.length()<3) {
									if(temp.length() != 3)
										temp = "0"+temp;
								}
								object_Codes.add(nixbpe_cal.CalFormat()+temp);
							}
						}
						else if(formatNumber == 3 && format_Four == true) {
							if((nixbpe.judgeIn()+" "+nixbpe.judgeOp()).equals("+op #m")) {
								String temp = Integer.toHexString(Integer.valueOf(Operator));
								while(temp.length()<5) {
									if(temp.length() != 5)
										temp = "0"+temp;
								}
								object_Codes.add(nixbpe_cal.CalFormat()+temp);
							}
							else
								object_Codes.add(nixbpe_cal.CalFormat()+"0"+sign);
						}
						else if(formatNumber == 2) {
							String format_Two_objcode = instruction_Opcodes.get(instruction.substring(start_Pos, end_Pos));
							String format_Two_Operator = instruction_Operator.get(instruction);
							char A = '0',X = '1',L = '2',B = '3', S = '4', T = '5', F = '6';
							for(int j=0;j<format_Two_Operator.length();j++) {
								if(format_Two_Operator.charAt(j) == 'A') {
									format_Two_objcode += A;
								}
								else if(format_Two_Operator.charAt(j) == 'X') {
									format_Two_objcode += X;
								}
								else if(format_Two_Operator.charAt(j) == 'L') {
									format_Two_objcode += L;
								}
								else if(format_Two_Operator.charAt(j) == 'B') {
									format_Two_objcode += B;
								}
								else if(format_Two_Operator.charAt(j) == 'S') {
									format_Two_objcode += S;
								}
								else if(format_Two_Operator.charAt(j) == 'T') {
									format_Two_objcode += T;
								}
								else if(format_Two_Operator.charAt(j) == 'F') {
									format_Two_objcode += F;
								}
							}
							while(format_Two_objcode.length() < 4) {
								format_Two_objcode = format_Two_objcode+"0";
							}
							object_Codes.add(format_Two_objcode);
						}
						break;
					}
				}
			}
			inputdata = false;
		}
	}
	
	public ArrayList<String> getObject(){
		return object_Codes;
	}
}