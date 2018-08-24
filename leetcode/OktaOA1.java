import java.util.*;
import java.lang.*;

public class OktaOA1{
	public boolean isSocket(String s){
		if(s == null) return false;

	String[] start = s.split("\\.");
	if(start.length != 4) return false;

	String[] last = start[3].split("\\:");
	if(last.length != 2) return false;

	for(int i=0; i<3; i++){
		int cur = -1;
		try{
			cur = Integer.parseInt(start[i]);
			if( cur < 0 || cur > 255) return false;
		} catch (NumberFormatException ne){
			return false;
		}
		
	}

	int cur = 0;
	try{
		cur = Integer.parseInt(last[0]);
		if( cur < 0 || cur > 255) return false;
	} catch (NumberFormatException ne){
		return false;
	}	

	try{
		cur = Integer.parseInt(last[1]);
		if(cur < 1 || cur > 65535) return false;
	} catch (NumberFormatException ne){
		return false;
	}

	

	return true;

}

public static void main(String[] args){
	OktaOA1 test = new OktaOA1();
	String s = "";
	System.out.println(test.isSocket(s));
}
}