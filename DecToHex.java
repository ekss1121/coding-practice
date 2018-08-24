import java.util.*;

public class DecToHex{

	public String convert(int n){
		if(n == 0 ) return "0";

		char[] map = {'0', '1','2','3','4','5','6','7','8',
						'9','a','b','c','d','e','f'};
		String rst = "";
		while(n != 0){
			rst = map[n & 15] + rst;
			n = (n >>> 4);
		}

		return rst;
	}

	public static void main(String[] args){
		DecToHex test = new DecToHex();
		System.out.println(test.convert(-1));
	}
}