import java.util.ArrayList;
public class Space_breaker {
	
	//負責切割空白與enter,和判別切割的字串要丟指令、標記、運算元的哪個位置，以及日後標記所對應Loc位置做存取
	public ArrayList<Integer>Pos;
	public ArrayList<String>Sign;
    public ArrayList<String>Instruction;
    public ArrayList<String>Operator;
	public data_Library dl;
	public Base_Location bl;
	public boolean is_Space = false;
	public boolean is_Instruction = false;
	public boolean is_Operator = false;
	public boolean input_door = true;
	public boolean byte_space = false;
	public boolean is_Base = false;
	public boolean is_Base_One = false;
	public boolean is_Base_Operator = false;
	public int start_Pos = 0;
	public int end_Pos = 0;
	public int count_Space = 0;
	public int count_Point_Pass = 0;   
	public String inputStr;
	
	public Space_breaker(String inputStr) {
		this.inputStr = inputStr;
		format_handle();
	}
	
	public void format_handle() {
		Sign = new ArrayList<String>();
		Instruction = new ArrayList<String>();
		Operator = new ArrayList<String>();
		Pos = new ArrayList<Integer>();
		dl = new Instruction_Op();
		bl = new Base_Location();
		inputStr = inputStr.replace("\r\n"," ");
	    for(int i=0;i<inputStr.length();i++) {
	    	//最後一個測資的處理
	    	if(i == inputStr.length() - 1) {
	    		is_Space = true;
	    		end_Pos = i+1;
	    	}
	    	//當遇到BYTE特例時所進行的處理
	    	if(inputStr.charAt(i) == '\'') {
	    		byte_space = !byte_space;
	    	}
	    	//遇到Space的處理
	    	if(inputStr.charAt(i) == ' ' && byte_space == false) {
	    		if(i == 0){
	    			start_Pos++;
	    			count_Space++;
	    		}
	    		else {
		    		is_Space = true;
		    		count_Space++;
		    		end_Pos = i;
	    		}
	    	}
	    	else 
	    		count_Space = 0;
	    	
	    	//字串有兩個以上的space處理方法
	    	if(count_Space > 1) {
	    		is_Space = false;
	    		start_Pos = end_Pos+1;
	    	}
	    	
	    	//儲存切割完的字串
	    	if(is_Space == true) {
	    		for(String instruction : dl.getMap().keySet()) {
	    			if(inputStr.substring(start_Pos, end_Pos).equals(instruction)||inputStr.substring(start_Pos, end_Pos).equals("+"+instruction)) {
	    				is_Instruction = true;
	    			}
	    		}
	    		//偵測到是Instruction
	    		if(is_Instruction == true) {
	    			if(!inputStr.substring(start_Pos, end_Pos).equals("BASE")) {
	    				Instruction.add(inputStr.substring(start_Pos, end_Pos)); 
	    				if(is_Base_One == false)
	    					bl.setPrevious(inputStr.substring(start_Pos, end_Pos));
	    			}
	    			else {
	    				is_Base = true;
	    				is_Base_One = true;
	    				is_Base_Operator = true;
	    			}
	    			
	    			is_Instruction = false;
	    			if(!inputStr.substring(start_Pos, end_Pos).equals("RSUB")) {
	    				is_Operator = true;
	    			}
	    			if(is_Base == true) {
	    				is_Base = false;
	    			}
	    		}
	    		//偵測為Operator
	    		else if(is_Instruction == false && is_Operator == true){
	    			String inputStr_noSpace = inputStr.substring(start_Pos, end_Pos);
	    			for(int j = i;;j++) {
	    				if(inputStr.charAt(j) == ' ') {
	    					continue;
	    				}
	    				else if(inputStr.charAt(j) == ',') {
	    					inputStr_noSpace += ",";
	    				}
	    				else if(inputStr.charAt(j) == 'X'&&inputStr.charAt(j+1) == ' ') {
	    					inputStr_noSpace += "X";
	    					i = j;
	    				}
	    				else
	    					break;
	    			}
	    			
	    			if(is_Base_Operator == false)
	    				Operator.add(inputStr_noSpace);
	    			if(is_Base_Operator == true) {
		    			bl.setOperator(inputStr.substring(start_Pos, end_Pos));
		    			is_Base_Operator = false;
		    		}
	    			
	    			is_Operator = false;
	    			input_door = true;
	    		}
	    		//偵測為Sign
	    		else{
	    			if(inputStr.substring(start_Pos, end_Pos).equals(".")) {
	    				count_Point_Pass++;
	    				input_door = false;
	    			}
	    			else if(input_door == true) {
	    				Sign.add(inputStr.substring(start_Pos, end_Pos));
	    				Pos.add(Instruction.size());
	    				input_door = false;
	    			}
	    			
	    			if(count_Point_Pass == 3) {
	    				input_door = true;
	    				count_Point_Pass = 0;
	    			}
	    		}
	    		start_Pos = end_Pos+1;
	    		is_Space = false;
	    	}
	    }
	}
	
	public ArrayList<String> getSignArrayList(){
		return Sign;
	}
	
	public ArrayList<String> getInstructionArrayList(){
		return Instruction;
	}
	
	public ArrayList<String> getOperatorArrayList(){
		return Operator;
	}	
	
	public ArrayList<Integer> getPosArrayList(){
		return Pos;
	}
	
	public String getBasePrevious() {
		return bl.getPrevious();
	}
	
	public String getBaseOperator() {
		return bl.getOperator();
	}
}