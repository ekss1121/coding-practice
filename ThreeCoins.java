public class ThreeCoins{
	public List<Integer> findSums(int[] coins){
		List<Integer> rst = new ArrayList<>();
		if(coins[0] > 1000) return rst;

		boolean[] sol = new boolean[1001];

		for(int i=0; i<sol.length; i++){
			
		}

		sol[coins[0]] = true;
		sol[coins[1]] = true;
		sol[coins[2]] = true;
		sol[0] = true;

		for(int i = coins[0] + 1; i<1001; i++){
			for(int value : coins){
				if(i > value && coins[i-value]){
					sol[i] = true;
					rst.add
				}else{
					continue;
				}
			}
		}
	}
}