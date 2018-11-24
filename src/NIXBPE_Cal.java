
public class NIXBPE_Cal {
	
	boolean is_Base_relative = false;
	public String Notation;
	public String Format;
	public String Operator_Loc;
	public String pc_Loc;
	public String Base_Operator;
	public PC_relative pc_Relative = new PC_relative();
	public Base_relative base_Relative = new Base_relative();
	public void setNotation(String Notation) {
		this.Notation = Notation;
	}
	
	public void setFormat(String Format) {
		this.Format = Format;
	}
	
	public void setBaseOperator(String Loc) {
		this.Base_Operator = Loc;
	}
	public void setOL(String Operator_Loc) {
		this.Operator_Loc = Operator_Loc;
	}
	
	public void setPL(String pc_Loc) {
		this.pc_Loc = pc_Loc;
	}
	
	public void is_Base() {
		is_Base_relative = !is_Base_relative;
	}
	
	public String CalFormat() {
		String Opcode_ni = Integer.toBinaryString(Integer.parseInt(Format,16));
		while(Opcode_ni.length() < 8) {
			if(Opcode_ni.length() != 8) {
				Opcode_ni = "0"+Opcode_ni;
			}
		}
		
		String n = "",i = "",x = "",b = "",p = "",e = "";
		if(Notation.equals("op c")) {
			n = i = "1";
			x = b = p = e = "0";
		}
		
		if(Notation.equals("+op m")) {
			n = i = e = "1";
			x = b = p = "0";
		}		
		
		if(Notation.equals("op m") && is_Base_relative == false) {
			n = i = p = "1";
			x = b = e = "0";
		}
		else if(Notation.equals("op m") && is_Base_relative == true) {
			n = i = b = "1";
			x = p = e = "0";
		}
		
		if(Notation.equals("op @c")) {
			n = "1";
			i = x = b = p = e = "0";
		}
		
		if(Notation.equals("+op @m")) {
			n = e = "1";
			i = x = b = p = "0";
		}
		
		if(Notation.equals("op @m") && is_Base_relative == false) {
			n = p = "1";
			i = x = b = e = "0";
		}
		else if(Notation.equals("op @m") && is_Base_relative == true) {
			n = b = "1";
			i = x = p = e = "0";
		}
		
		if(Notation.equals("op #c")) {
			n = x = b = p = e = "0";
			i = "1";
		}
		
		if(Notation.equals("+op #m")) {
			n = x = b = p = "0";
			i = e = "1";
		}
		
		if(Notation.equals("op #m") && is_Base_relative == false) {
			i = p = "1";
			n = x = b = e = "0";
		}
		else if(Notation.equals("op #m") && is_Base_relative == true) {
			i = b = "1";
			n = x = p = e = "0";
		}
		
		Opcode_ni = Opcode_ni.substring(0,Opcode_ni.length()-2)+n;
		Opcode_ni = Opcode_ni+i;
		
		String Opcode = Integer.toHexString(Integer.parseInt(Opcode_ni,2)).toUpperCase();
		while(Opcode.length() < 2) {
			if(Opcode.length() != 2) {
				Opcode = "0"+Opcode;
			}
		}
		
		String Opcode_xbpe = Integer.toHexString(Integer.parseInt(x+b+p+e,2)).toUpperCase();
		Opcode += Opcode_xbpe;
		
		if(b.equals("0")&&p.equals("0")) {
			return Opcode;
		}
		else {
			if(is_Base_relative == false) {
				pc_Relative.setOL(Operator_Loc);
				pc_Relative.setpc(pc_Loc);
				String Disp_or_Addr = pc_Relative.cal();
				if(Disp_or_Addr.equals("is Base")) {
					return "again";
				}
				else {
					Opcode += Disp_or_Addr;
					return Opcode;
				}
			}
			else {
				base_Relative.setOL(Operator_Loc);
				base_Relative.setBL(Base_Operator);
				String Disp_or_Addr = base_Relative.cal();
				Opcode += Disp_or_Addr;
				return Opcode;
			}
		}
	}
	
	
}
