public class upAndDownMax{
    public static int solution(int[] nums){
        if(nums.length < 3) return nums[nums.length-1];
        int lo = 0;
        int hi = nums.length - 1;
        while(lo +1 < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid-1] < nums[mid] && nums[mid+1] > nums[mid]){
                lo = mid;
            } else if(nums[mid-1] > nums[mid] && nums[mid+1] < nums[mid]){
                hi = mid;
            } else{
                return nums[mid];
            }
        }

        return Math.max(nums[lo], nums[hi]);
    }

    public static void main(String[] args){
        int[] nums = {1,3,2};
        int ans = upAndDownMax.solution(nums);
        System.out.println(ans);
    }
}
