
public class Base_relative {
	
	public String Operator_Loc;
	public String base;
	
	public void setOL(String Operator_Loc) {
		this.Operator_Loc = Operator_Loc;
	}
	
	public void setBL(String base) {
		this.base = base;
	}
	
	public String cal() {
		int Operator_Loc_int = Integer.parseInt(Operator_Loc,16);
		int base_Loc_int = Integer.parseInt(base,16);
		String total = Integer.toHexString(Operator_Loc_int - base_Loc_int).toUpperCase();
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
