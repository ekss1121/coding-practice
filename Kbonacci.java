public class Kbonacci{

    static String findAns(int k, int n){
        if(n <= k) return "1";
        String[] memo = new String[n];
        for(int i=0; i<k; i++){
            memo[i] = "1";
        }
        for(int i=k; i<n; i++){
            String addition = "0";
            for(int j=i-1; j>=i-k; j--){
                addition = addString(addition, memo[j]);
            }
            memo[i] = addition;
        }
        return memo[n-1];
    }

    static private String addString(String a, String b){
        int add = 0;
        int i = a.length()-1;
        int j = b.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j >=0 || add > 0){
            int a1 = 0;
            if(i >= 0){
                a1 = Character.getNumericValue(a.charAt(i));

            }
            int b1 = 0;
            if( j >= 0){

                b1 = Character.getNumericValue(b.charAt(j));
            }

            int cur = (a1 + b1 + add) % 10;
            add = (a1 + b1 + add) / 10;
            sb.append(Integer.toString(cur)); 

            j--;
            i--;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(Kbonacci.findAns(2,500));
    }
}