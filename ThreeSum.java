import java.util.*;

public class ThreeSum{
	public List<List<Integer>> findIndex(int[] nums){
		List<List<Integer>> rst = new ArrayList<>();
		if(nums == null || nums.length < 3){
			return rst;
		}

		Arrays.sort(nums);
		ArrayList<Integer> tmp = new ArrayList<>();
		for(int i=0; i<nums.length -2; i++){
			for(int j=i+1, k=nums.length-1; j<k;){
				if(nums[i] + nums[j] + nums[k] < 0){
					j++;

					while(j < k && nums[j] == nums[j-1]) j++;
				}else if(nums[i] + nums[j] + nums[k] >0){
					k--;
					while(k > j && nums[k] == nums[k+1]) k--;
				}else{
					while(j < nums.length -1){
						for(int index = k; index > j;){
							//System.out.println(i);
							//System.out.println(j);
							//System.out.println(index);
							//System.out.println();
							//System.out.println(index);
							tmp.add(i);
							tmp.add(j);
							tmp.add(index);
							rst.add(new ArrayList<Integer>(tmp));
							tmp.clear();
							if(nums[index-1] == nums[index]){
								index--;
							}else{
								break;
							}
						}
						if(nums[j+1] == nums[j]){
							j++;
						}else{
							break;
						}
						
					}

					j++;
					k--;
				}
			}
		}

		return rst;
	}

	public static void main(String args[]){
		ThreeSum sol = new ThreeSum();
		int[] nums = new int[]{0,0,0,0,0};
		List<List<Integer>> solution = sol.findIndex(nums);

		for(int i=0; i<solution.size(); i++){
			for(int j=0; j< 3; j++){
				System.out.print(solution.get(i).get(j) + " ");
			}
			System.out.println(" ");
		}
	}
}



