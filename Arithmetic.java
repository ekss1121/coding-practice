class Arithmetic{
    public static int brutalForce(int[] A){
        // two pointers
        if(A == null || A.length < 3){
            return 0;
        }
        int count = 0;
        for(int s = 0; s<A.length-2; s++){
            int d = A[s+1] - A[s];
            for(int e = s+2; e<A.length; e++){
                if(A[e] - A[e-1] == d){
                    count++;
                }else{
                    s = e - 2;
                    break;
                }
            }
        }

        return count;
    }

    public static int recursive(int[] A){
        if (A == null || A.length < 2)
            return 0;
        // recursive approach
        int rtn = 0;
        return rtn;
    }

    public static void main(String[] args) {
        int[] test = new int[]{7,-1,7,7};
        System.out.println(Arithmetic.brutalForce(test)); 
    }
}