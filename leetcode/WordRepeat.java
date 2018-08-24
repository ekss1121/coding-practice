import java.util.*;
public class WordRepeat{ // Detect if input has reapeat words

	//private static final Integer ONE = new Integer(1);
	private static final int ONE = 1;

	public static void main(String[] args){
		// defind hashmap
		Map<String, Integer> m = new HashMap<>();
		for(int i=0; i < args.length; i++){
			//Integer freq = (Integer) m.get(args[i]);
			int freq = m.get(args[i]) == null ? 0:
				 m.get(args[i]);

			if(freq == 0){
				m.put(args[i], ONE);
			}else{
				m.put(args[i], (freq + 1));
			}
		}

		System.out.println(m.size() + " distict words detected");
		System.out.println(m);

	}
}