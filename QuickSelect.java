import java.util.*;
class QuickSelect{
    // a demo code to find the kth smallest number in an unsorted array with unique numbers
    static int topK(int[] nums, int k){
        // assume the nums has length larger than k
        assert nums.length > k;

        // use partition to find the kth largest number.
        return partition(nums, 0, nums.length - 1, k);
    }

    private static int partition(int[] nums, int start, int end, int k){
        if(start == end){
            return nums[start];
        }

        // select the last one as the pivot number
        int pivot = nums[end];
        int i, j;
        for( i = -1, j=0; j < end; j++){
            if(nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i+1, end);

        if(i+1 > k){
            return partition(nums, start, i, k);
        }else{
            return partition(nums, i+1, end, k);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,2,3,7,8};
        int k = 2;
        System.out.println(QuickSelect.topK(nums, k));
    }
}