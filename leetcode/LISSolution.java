import java.util.*;

public class LISSolution{
	public int findLIS(String s){
		if(s.length() <= 1)
			return s.length();

		// longest substring ends at [i]
		int[] dp = new int[s.length()];
		Arrays.fill(dp, 1);

		dp[0] = 1;

		for(int i=1; i<s.length(); i++){
			for(int j=0; j< i; j++){
				if(s.charAt(i) > s.charAt(j)){
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}

		return dp[s.length() -1];
	}

	public static void main(String[] args){
		LISSolution lis = new LISSolution();
		String s = "fbamcde";
		System.out.println("result: " + lis.findLIS(s));
	}
}

/*
1 7 2 4 6 10

dp[i] = MAX(dp[j], j<i && s.charAt(j) < s.charAt(i)) + 1



*/