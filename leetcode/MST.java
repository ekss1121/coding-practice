public class MST{
	private static final int V = 5;
	public void primMST(int[][] graph){
		// store MST with an array
		int[] parent = new int[V];
		int[] key = new int[V];
		boolean[] mstSet = new boolean[V];

		for(int i=0; i<V; i++){
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		parent[0] = 0;
		key[0] = -1;

		for(int i=1; i<)


	}

	private int getMinKey(int[] key, boolean[] mstSet){
		int min = Integer.MAX_VALUE;
		int min_index = -1;
		for(int i=1; i<key.length; i++){
			if(mstSet == false && key[i] < min){
				min = key[i];
				min_index = i;
			}
		}

		return min_index;
	}

	private printMST(int[] parent){

	}
}