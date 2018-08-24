public class MergeSort{
	public int[] mergeSort(int[] nums){
		if(nums == null || nums.length == 0) return null;

		/// divide and conquer
		return sortHeper(nums, 0, nums.length);
	}

	private int[] sortHeper(int[] nums, int start, int end){
		if(start + 1 >= end){
			return new int[]{nums[start]};
		}

		//divide
		int mid = start + (end - start) /2 ;
		// conquer
		return merge(sortHeper(nums, start, mid), 
				sortHeper(nums, mid, end));
	}

	private int[] merge(int[] left, int[] right){
		int m = left.length;
		int n = right.length;
		int[] aux = new int[m+n];

		int index = Math.min(m,n);
		int i=0, j=0, k=0;
		while(j< m && k <n){
			if(left[j] <= right[k]) {
				aux[i] = left[j];
				j++;
			}else{
				aux[i] = right[k];
				k++;
			}
			i++;
		}

		while( j < m){
			aux[i++] = left[j++];
		}

		while(k < n){
			aux[i++] = right[k++];
		}

		return aux;
	}

	public static void main(String[] args){
		// test main fucntion
		int[] a = new int[]{1,4,10,17,22};
		int[] b = new int[]{2,5,7};
		int[] test = new int[]{1,7,2,4,6,10,5,9,0,2,-1,-9};
		//int[] result = mergeSort(test);

		MergeSort sol = new MergeSort();
		int[] result = sol.mergeSort(test);

		for(int i=0; i<result.length; i++){
			System.out.println(result[i]);
		}
		
	}
}











