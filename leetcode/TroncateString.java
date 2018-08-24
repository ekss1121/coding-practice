public class TroncateString{
	public String tr(String s, int n){
		if(s == null || s.length() == 0) return new String("");

		if(s.length() == n) return s;

		if(s.charAt(n-1) == ' '){
			return s.substring(0, n-1);
		}else if(s.charAt(n) == ' '){
			return s.substring(0,n);
		}else{
			for(int i=n-1; i>= 0; i--){
				if(s.charAt(i) == ' '){
					return s.substring(0,i);
				}
			}
		}

		return new String("");
	}

	public static void main(String[] args){
		String test = "Iam fucked up this interview within 15 mins";
		TroncateString Tr = new TroncateString();
		String rtn = Tr.tr(test, 2);

		System.out.println(rtn);
	}
}