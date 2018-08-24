import java.util.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int num){
		this.val = num;
	}
}

class TestClone{

	
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = node1;

		System.out.println(node1 == node2);
	}
}