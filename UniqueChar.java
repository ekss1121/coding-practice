public class UniqueChar{
    public static boolean isUnique(String s){
        // assuming s only contains 'a~z'
        if(s == null || s.length() == 0) return false;
        int checker = 0;
        for(int i=0; i<s.length(); i++){
            int val = s.charAt(i) - 'a';
            if((checker & (1 << val)) > 0) return false;
            checker = checker | (1 << val);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(UniqueChar.isUnique(args[0]));
    }
}