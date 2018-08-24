import java.util.*;
import BinarySearchTree;
class KEmptyList{
    /**
     * leetcode 683:
     * Author: Zhihang
     * Date: 7/30/2018
     */

     public int bruteForce(int[] input, int k){
         if(input.length < k + 2){
             return -1;
         }
         int[] flowers = new int[input.length];
         for(int i=0; i<input.length; i++){
            flowers[input[i]] = 1;
            boolean isValid = false;
            if(input[i] >= k+1){
                if(flowers[input[i] - k - 1] > 0){
                    isValid = checkNeighbours(flowers, input[i] - k, input[i] - 1);
                }
            }

            if(input[i] + k + 1 < input.length){
                if(flowers[input[i] + k  + 1] > 0){
                    isValid = checkNeighbours(flowers, input[i] + 1, input[i] + k);
                }
            }

            if(isValid) return i;

         }
         return -1;
     }

     private boolean checkNeighbours(int[] flowers, int start, int end){
        while(start <= end){
            if(flowers[start] > 0){
                return false;
            }
            start++;
        }

        return true;
    }

     public int BST(int[] input, int k){
         /**
          * Implementd a balanced tree with Java TreeSet;
          * every time after insert an element: check:
          *     1. prev(x) = x - k - 1;
          * ||  2. next(x) = x + k + 1;
          */

        if(input.length < k + 2){
            return -1;
        }
        
        BinarySearchTree bst = new BinarySearchTree();
        
        return 0;
     }

     public int bucket(int[] input, int k){
         return 0;
     }

     public static void main(String[] args) {
        KEmptyList sol = new KEmptyList();
        int[] input = new int[]{0,4,1,3,2};
        int k = 2;
        System.out.println(sol.bruteForce(input, k));
     }
}