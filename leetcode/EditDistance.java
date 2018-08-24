public class EditDistance{
	private int findDistance(String s1, String s2){
		if(s1 == null || s2 == null) return -1;

		if(s1.length() > s2.length()){
			String tmp = s1; // always assume s1.elngth() <= s2.length()
			s1 = s2;
			s2 = tmp;
		}

		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m][n];

		return 0
	}

	public static void main(String[] args){

	}
}