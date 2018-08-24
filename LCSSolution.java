public class LCSSolution{
	public int findLCS(String s1, String s2){
		// dp
		if(s1 == null || s1.length() == 0) return 0;
		if(s2 == null || s2.length() == 0) return 0;

		// LCS of s1 ends with i and s2 ends with j;
		int[][] dp = new int[s1.length()][s2.length()];
		
		//dp[0][0] = 0;

		for(int i=1; i<s1.length(); i++){
			for(int j=1; j<s2.length(); j++){
				if(s1.charAt(i) == s2.charAt(j)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
					//dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
				}
			}
		}

		return dp[s1.length() -1][s2.length() -1];

	}

	public static void main(String[] args){
		LCSSolution lcs = new LCSSolution();
		String s1 = "abcfe";
		String s2 = "afe";

		System.out.println(lcs.findLCS(s1,s2));
	}
}


/*
"abcfe"
"afe"
*/