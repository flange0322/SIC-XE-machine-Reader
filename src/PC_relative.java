public class PC_relative {
	
	public String Operator_Loc;
	public String pc;
	public void setOL(String Operator_Loc) {
		this.Operator_Loc = Operator_Loc;
	}
	
	public void setpc(String pc) {
		this.pc = pc;
	}
	
	public String cal() {
		int Operator_Loc_int = Integer.parseInt(Operator_Loc,16);
		int pc_int = Integer.parseInt(pc,16);
		int Base_detect = 0;
		if(Operator_Loc_int > pc_int)
			Base_detect = Operator_Loc_int - pc_int;
		else
			Base_detect = pc_int - Operator_Loc_int;
		
		if(Base_detect > 4095)
			return "is Base";
		else {
			String total = Integer.toHexString(Operator_Loc_int - pc_int).toUpperCase();
			while(total.length()<3) {
				if(total.length() != 3) {
					total = "0"+total;
				}
			}
			if(total.length() > 3) {
				total = total.substring(total.length()-3);
			}
			return total;
		}
	}
}