public class QuickSort{
	public void quickSort(int[] nums){
		// chhoose partition number
		// partition
		if(nums == null || nums.length == 0) return ;
		sortHelper(nums, 0, nums.length);
		return ;
	}

	private void sortHelper(int[] nums, int start, int end){
		if(start +1 >= end){
			return ;
		}

		int mid = start + (end - start) /2;
		// partition
		int p_number = nums[mid];
		int left = start;
		int right = end -1;
		while( left != right){
			while(nums[left] < p_number) left ++;
			while(nums[right] > p_number) right --;

			if(left == right) break ;

			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
		}

		sortHelper(nums, start, left);
		sortHelper(nums, left+1, end);
	}

	public static void main(String[] args){
		int[] test = new int[]{1,7,2,4,6,10,-9,-1,0,5,12};

		QuickSort sort = new QuickSort();
		sort.quickSort(test);

		for(int number : test){
			System.out.println(number);
		}
	}
}