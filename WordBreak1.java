import java.util.*;

public class WordBreak1{
	public List<String> breakWord(String s){
		List<String> rst = new ArrayList<>();
		if(s == null || s.length() == 0) return rst;

		// applepie

		for(int i=1; i<s.length(); i++){
			String s1 = s.substring(0,i);
			String s2 = s.substring(i, s.length());
			if(isWord(s1) && isWord(s2)){
				rst.add(s1);
				rst.add(s2);
			}
		}

		return rst;
	}

	private boolean isWord(String s){
	}
}