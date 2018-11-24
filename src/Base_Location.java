public class Base_Location {
	protected String previous_Instruction;
	protected String Base_Operator;
	
	public void setPrevious(String previous_Instruction) {
		this.previous_Instruction = previous_Instruction;
	}
	
	public void setOperator(String Base_Operator) {
		this.Base_Operator = Base_Operator;
	}
	
	public String getPrevious() {
		return previous_Instruction;
	}
	
	public String getOperator() {
		return Base_Operator;
	}
}