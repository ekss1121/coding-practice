import java.util.*;


public class MergeSquare{

	private class Square{
		int[] origin;
		int w;
		int h;
		public Square(String s){
			String[] s_split= s.split(" ");
			origin = new int[2];
			origin[0] = Integer.parseInt(s_split[0]);
			origin[1] = Integer.parseInt(s_split[1]);
			this.w = Integer.parseInt(s_split[2]);
			this.h = Integer.parseInt(s_split[3]);
		}
	}

	public String merge(List<String> suqares){
		List<String> rst = new ArrayList<>();
		if(squares == null || squares.size() == 0){
			return rst;
		}
		Square rtn = new Square("0 0 0 0");
		for(String s : squares){
			Square cur = Square(s);
		}
		return rst;
	}
}