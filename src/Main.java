import java.io.*;
public class Main {
	public static void main(String args[]) throws Exception{
		FileInputStream fileStream = new FileInputStream ("questions_example.txt");  
	    DataInputStream DIS = new DataInputStream (fileStream);  
	  
	    byte[] dataInputBytes = new byte[DIS.available()];  
	    DIS.readFully(dataInputBytes);  
	    DIS.close();  
	    
	    String inputStr = new String(dataInputBytes);
	    
	    Space_breaker SB = new Space_breaker(inputStr);
	    
	    Instruction_Op opcode = new Instruction_Op();
	    
	    Instruction_Operator IO = new Instruction_Operator(SB.getInstructionArrayList(),SB.getOperatorArrayList());
	    
	    Loc_Arithmetic LA = new Loc_Arithmetic(IO.getMap().get(IO.getFirst_Loc()),IO.getMap());
	    
	    Sign_Loc SL = new Sign_Loc(IO.getMap().get(IO.getFirst_Loc()),SB.getSignArrayList(),LA.getLoc(),SB.getPosArrayList());
	        
	    Object_Code OC = new Object_Code(IO.getMap(),SL.getMap(),new Instruction_Op().getMap(),LA.getLoc(),SB.getBaseOperator());
	    
	    /*System.out.println("******** Print Loc ********");
	    for(int i=0;i<LA.getLoc().size();i++) {
	    	System.out.println(i+"."+LA.getLoc().get(i));
	    }*/
	    
	    
	    /*System.out.println("******** Print Object Code ********");
	    for(int i=0;i<OC.getObject().size();i++) {
	    	System.out.println(OC.getObject().get(i));
	    }*/
	    
	   /* for(int i=0;i<SB.getSignArrayList().size();i++) {
    		System.out.println(SB.getSignArrayList().get(i));
    	}*/
	   
	    /*for(int i=0;i<SB.getInstructionArrayList().size();i++) {
	    	System.out.println(SB.getInstructionArrayList().get(i));
	    }*/
	    
	   /* for(int i=0;i<SB.getOperatorArrayList().size();i++) {
	    	System.out.println(SB.getOperatorArrayList().get(i));
        }*/
	    
	    /*for(int i=0;i<SB.getPosArrayList().size();i++) {
		System.out.println(SB.getPosArrayList().get(i));
        }*/
    
	    /*for(String key : IO.getMap().keySet()) {
    	System.out.println(key+" "+IO.getMap().get(key));
        }*/
	    
	    /*for(String key : SL.getMap().keySet()) {
	    	System.out.println(key+" "+SL.getMap().get(key));
	    }*/
	   	    
	    //®æ¦¡¿é¥X
	    boolean non_Sign = false;
	    String repeat = "";
	    int j = 0;
	    System.out.println(" Loc    SourceStateMent      ObjectCode");
	    for(int i = 0;i<LA.getLoc().size();i++) {
	    	int length = 0;
	    	length += (LA.getLoc().get(i)+" ").length();
	    	System.out.print(LA.getLoc().get(i)+"    ");
	    	for(String key : SL.getMap().keySet()) {
	    		if(LA.getLoc().get(i).equals(SL.getMap().get(key))) {
	    			if(!repeat.equals(key)) {
	    				repeat = key;
	    			}
	    			else 
	    				continue;
	    			
	    			System.out.print(key+" ");
	    			length += (key+" ").length();
	    			non_Sign = false;
	    			break;
	    		}
	    		else {
	    			non_Sign = true;
	    		}
	    	}
	    	if(non_Sign == true) {
	    		length += 6;
	    		System.out.print("      ");
	    	}
	    	length += (SB.getInstructionArrayList().get(i)+" ").length();
	    	System.out.print(SB.getInstructionArrayList().get(i)+" ");	    	
	    	for(String key : IO.getMap().keySet()) {
	    		if(key.equals((i+1)+"."+SB.getInstructionArrayList().get(i))) {
	    			if(!IO.getMap().get(key).equals("null")) {
	    				length += IO.getMap().get(key).length();
	    				System.out.print(IO.getMap().get(key));
	    			}
	    		}
	    		for(String key_2 : opcode.getMap().keySet()) {
	    			if((key.equals((i+1)+"."+key_2) || key.equals((i+1)+".+"+key_2)) && !key.equals((i+1)+".RESW") && !key.equals((i+1)+".RESB") && !key.equals((i+1)+".END") && !key.equals((i+1)+".START")) {
	    				for(int l=0;l<(27-length);l++) {
	    					System.out.print(" ");
	    				}
	    				System.out.println(" "+OC.getObject().get(j));
	    				j++;
	    				break;
	    			}
	    			else if((key.equals((i+1)+"."+key_2) || key.equals((i+1)+".+"+key_2))&&(key.equals((i+1)+".RESW")|| key.equals((i+1)+".RESB") || key.equals((i+1)+".END") || key.equals((i+1)+".START"))){
	    				System.out.println();
	    			}
	    		}
	    	}
	    }
	   
	}
}
