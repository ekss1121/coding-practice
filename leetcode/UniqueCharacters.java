import java.util.*;

public class UniqueCharacters{
    public static boolean ifUnifuqe(String s){
        if(s == null || s.length() == 0) return false;
        // use no additional data structures
        int[] dic  = new int[256];
        for(char c : s.toCharArray()){
            if(dic[c - '0'] > 0) return false;
            dic[c - '0']++;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = args[0];
        System.out.println(ifUnifuqe(input));
    }
}
