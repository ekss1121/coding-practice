import java.util.*;

public class TreeSerializer{

    public static String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        /**
         * main logic: recursive solution
         * Use JSON like version
         * Tree: {2, {left sub tree}, {right sub Tree}}
         * 
         */
        if(root == null){
            return sb.toString();
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        if(left.equals("") && right.equals("")){
            return root.val + "";
        } else{
            sb.append(root.val + ",");
            sb.append(left + ",");
            sb.append(right + "}");
        }
        

        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        String rst = TreeSerializer.serialize(root);
        System.out.println(rst);
    }
}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){this.val = val;}
}