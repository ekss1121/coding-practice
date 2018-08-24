class LargestRec {
    public int largestRectangleArea(int[] heights) {
        // n^2 solution
        /*
        if(heights == null || heights.length == 0) return 0;
        
        int n = heights.length;
        int max = 0;
        for(int i=0; i<n; i++){
            int left = i;
            int right = i;
            for(left = i; left>=0; left--){
                if(heights[left] < heights[i]) break;
            }
            for(right = i; right<n; right++){
                if(heights[right] < heights[i]) break;
            }
            
            max = Math.max(heights[i] * (right - left - 1), max);
        }
        
        return max;
        */

        // O(n) solution: using stack
        // input: [2,1,3,5,6,4];
        // index: [0,1,2,3,4,5];
        // stack: [-1,2,3]
        // area: 2 *( 1 - (-1) - 1)
        // max: 2


    }
}