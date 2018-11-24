public class NIXBPE_judge {
	
	public String Instruction;
	public String Operator;
	public void set_InsOpe(String Instruction,String Operator) {
		this.Instruction = Instruction;
		this.Operator = Operator;
	}
	
	public String judgeIn() {
		String judge = "";
		if(Instruction.charAt(0) == '+') 
			judge = "+op";
		else
			judge = "op";
		return judge;
	}
	
	public String judgeOp() throws NumberFormatException{
		String judge = "";
		String Op_Content = "";
		boolean Operator_OK = false;
		if(Operator.charAt(0) == '#') {
			judge = "#";
			Op_Content = Operator.substring(1, Operator.length());
		}
		else if(Operator.charAt(0) == '@') {
			judge = "@";
			Op_Content = Operator.substring(1, Operator.length());
		}
		else {
			Op_Content = Operator.substring(0, Operator.length());
		}
		for(int i=0;i<=4096;i++) {
			if(String.valueOf(i).equals(Op_Content) && i != 4096) {
				judge += "c";
				Operator_OK = true;
			}
			else if(i == 4096 && String.valueOf(i).equals(Op_Content)) {
				judge += "m";
				Operator_OK = true;
			}
		}
		if(Operator_OK == false) {
			judge += "m";
		}
		return judge;
	}
}
