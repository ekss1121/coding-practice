import java.util.*;


public class GoogleOA2{

	private int[] A;
	private int[] E;
	private int ans;

	private class TreeNode{
		int val;
		List<TreeNode> neighbors;
		public TreeNode(int val){
			this.val = val;
			neighbors = new ArrayList<>();
		}
	}

	public int solution(int[] A, int[] E){
		if(A == null || E == null) return -1;
		if(A.length == 0 || E.length == 0) return -1;
		this.A = A;
		this.E = E;
		TreeNode root = null;
		root = buildTree(0);
		
		ans = 0;
		findSolution(root);
		return ans;
	}

	private int findSolution(TreeNode root){
		if(root == null) return 0;

		List<TreeNode> neighbors = root.neighbors;
		int[] children = new int[neighbors.size()];
		for(int i=0; i<neighbors.size(); i++){
			children[i] = findSolution(neighbors.get(i));
		}
		int[] children_sum = new int[neighbors.size()];

		for(int i = 0; i<neighbors.size(); i++){
			TreeNode cur = neighbors.get(i);
			if(root.val == cur.val) children_sum[i] += children[i] + 1;
		}

		int max_1 = 0;
		int max_2 = 0;
		for(int i : children_sum){
			if(i > max_1){
				max_2 = max_1;
				max_1 = i;
			}else if(i > max_2){
				max_2 = i;
			}
		}
		ans = Math.max(ans, max_1 + max_2);
		int rtn = 0;
		for(int i : children_sum){
			rtn = Math.max(rtn, i);
		}

		return rtn;

	}

	private TreeNode buildTree(int index){

		TreeNode root = new TreeNode(A[index]);
		for(int i=0; i<E.length; i=i+2){
			if(E[i] == index + 1){
				int n = E[i+1];
				root.neighbors.add(buildTree(n-1));
			}
		}

		return root;

	}

	public static void main(String[] args) {
		int[] A = new int[]{6,2,6,4,5,6,6};
		int[] B = new int[]{1,2,1,3,1,4,1,5,1,6,6,7};

		GoogleOA2 sol = new GoogleOA2();
		System.out.println(sol.solution(A, B));
	}
}