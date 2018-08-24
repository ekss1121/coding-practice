import java.util.*;

public class QuickSelection{
    public int[] solution(int[] nums, int k){
        if(num == null || num.length == 0) return null;

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while(lo < hi){
            int j = partition(nums, lo, hi);
            if(j < k){
                lo = j+1;
            }else if(j > k){
                hi = j-1;
            }else{
                return nums[j];
            }
        }
    }

    private int partition(int[] nums, int lo, int hi){
        int i = lo;
        int j = hi;
        while(i < j){
            while(i < hi && nums[i] <= nums[lo]){
                i++;
            }

            while(j > lo && nums[j] >= nums[lo]){
                j--;
            }

            if(i<j) swap(nums, i,j);
        }

        swap(nums, j, lo);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
