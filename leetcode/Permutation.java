import java.util.*;

public class Permutation{
	public List<String> findPermuations(String s){
		List<String> rst = new ArrayList<>();
		if(s == null || s.length() == 0) return rst;
		char[] sArray = s.toCharArray();
		Arrays.sort(sArray);
		boolean[] visited = new boolean[sArray.length];
		StringBuilder sb = new StringBuilder();
		find_helper(rst, sArray, sb, visited);

		return rst;
	}

	private void find_helper(List<String> rst, char[] sArray, StringBuilder sb, boolean[] visited){
		if(sb.length() == sArray.length){
			rst.add(sb.toString());
			return;
		}

		for(int i=0; i<sArray.length; i++){
			if(visited[i] || (i!=0 && sArray[i-1] == sArray[i] && !visited[i-1])){
				continue;
			}

			sb.append(sArray[i]);
			visited[i] = true;
			find_helper(rst, sArray, sb, visited);
			sb.deleteCharAt(sb.length()-1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		Permutation test = new Permutation();
		String s = "dbbc";
		List<String> rst = test.findPermuations(s);
		for(String ss : rst){
			System.out.println(ss);
		}
	}
}