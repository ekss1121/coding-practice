import java.util.*;

public class IsAnagram{
	public boolean isAnagram(String s1, String s2){
		if(s1 == null || s2 == null) return false;
		if(s1.length() != s2.length()) return false;
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<s1.length(); i++){
			char c1 = s1.charAt(i);
			Integer count = map.get(c1);
			if(count != null){
				map.put(c1, count+1);
			}else{
				map.put(c1, 1);
			}
			char c2 = s2.charAt(i);
			count = map.get(c2);
			if(count != null){
				map.put(c2, count-1);
			}else{
				map.put(c2, -1);
			}
			
		}

		// check if all values are zero
		for(Object n : map.values()){
			if((int)n != 0){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsAnagram test = new IsAnagram();
		String s1 = "a!~@qw";
		String s2 = "!aweq@~";

		System.out.println(test.isAnagram(s1,s2));
	}
}