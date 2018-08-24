public List<Integer> verticalTraverse(TreeNode root){
	List<Integer> rst = new ArrayList<>();
	Map<Integer, List<Integer>> map = new HashMap<>();

	int colMin = Integer.MAX_VALUE;
	int colMax = Integer.MIN_VALUE;

	dfs(0, root, map, rst, colmin, colMax);

	for(int i=colMin; i<=colMax; i++){
		rst.addAll(map.get(i));
	}

	return rst;
}

private void dfs(int col, TreeNode root, Map<Integer, List<Integer>> map, 
	int minCol, int maxCol){
	if(root == null) return;
	if(!map.containsKey(col)){
		map.put(col, new ArrayList<Integer>());
	}

	map.get(col).add(root.val);
	minCol = Math.min(minCol, col);
	maxcol = Math.max(maxCol, col);
	dfs(col-1, root.left, map, minCol, maxCol);
	dfs(col+1. root.right, map, minCol, maxCol);
}

//LC 17

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<>();
        if(digits.length() == 0) return rst;
        String[] mapping = new String[] {" ", "1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        dfs("", digits, mapping, 0,rst);
        
        return rst;
    }
    private void dfs(String prefix, String digits, String[] mapping, int offset, List<String> rst){
        
        if(prefix.length() == digits.length()){
            rst.add(prefix);
        }
        int x = Character.getNumericValue(digists.charAt(offset));
        for(int i=0; i<mapping[x].length(); i++){
            dfs(prefix + mapping[x].charAt(i), digits, mapping, offset + 1, rst);
        }
    }
}