public class SwapTest{
	public static void main(String[] args){
		int[] nums = {3,1,2,5,6,4};
		swap(nums,0,1);

		for (int i=0; i< nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println("");
	}

	private static void swap(int[] nums, int i, int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}