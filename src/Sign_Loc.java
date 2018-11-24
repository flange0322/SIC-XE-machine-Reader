import java.util.ArrayList;
import java.util.LinkedHashMap;
public class Sign_Loc extends data_Library{

	//建立標記和Loc相對應的Table(SYM-TAB)
	ArrayList<Integer>Sign_Pos;
	ArrayList<String>Sign;
	LinkedHashMap<String,String> sign_Loc;
	ArrayList<String>Loc;
	String start_Loc;
	public Sign_Loc(String start_Loc,ArrayList<String>Sign,ArrayList<String>Loc,ArrayList<Integer>Sign_Los) {
		this.start_Loc = start_Loc;
		this.Sign = Sign;
		this.Loc = Loc;
		this.Sign_Pos = Sign_Los;
		sign_Loc = new LinkedHashMap<String,String>();
		Combination();
	}
	
	public void Combination() {
		for(int i=0;i<Sign.size();i++) {
			sign_Loc.put(Sign.get(i),Loc.get(Sign_Pos.get(i)));
		}
	}
	
	public LinkedHashMap<String, String> getMap() {
		return sign_Loc;
	}	
}