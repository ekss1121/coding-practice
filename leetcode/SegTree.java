import java.util.*;
/**
    This is an implementaion of Segment Tree
    @Author: Zhihang Liu
    @Date: 07/03/2018
 */
public class SegTree{
    TreeNode root;
    int[] nums;
    int[] prefixSum;
    public SegTree(int[] nums){
        this.nums = nums;
        this.prefixSum = new int[nums.length+1];
        for(int i=0; i<nums.length; i++){
            prefixSum[i+1] = nums[i] + prefixSum[i];
        }
        this.root = this.buildTree(prefixSum, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] prefixSum, int l, int r){
        if(l == r) return new TreeNode(prefixSum[r+1] - prefixSum[l], l, r);

        TreeNode root = new TreeNode(prefixSum[r+1] - prefixSum[l], l, r);
        int mid = l + (r - l) / 2;
        root.left = buildTree(prefixSum, l, mid);
        root.right = buildTree(prefixSum, mid+1, r);

        return root;
    }

    public void update(int val, int index){
        int diff = val - nums[index];
        updateHelper(diff, index, this.root);

    }

    private void updateHelper(int diff, int index, TreeNode root){
        if(root == null) return;
        if(index >= root.index[0] && index <= root.index[1]){
            root.val += diff;
        }
        updateHelper(diff, index, root.left);
        updateHelper(diff, index, root.right);
    }

    public int getSum(int l, int r){
        return getSumHelper(l, r, this.root);
    }

    private int getSumHelper(int l, int r, TreeNode root){
        if(r < root.index[0] || l > root.index[1]) return 0;

        if(root.index[0] >= l && root.index[1] <= r){
            return root.val;
        }else{
            return getSumHelper(l, r, root.left) + getSumHelper(l, r, root.right);
        }
    }

    public void printTree(){
        // print Tree with each level, seperated by ';'
        List<List<Integer>> tree = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this.root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            tree.add(level);
        }
        String output = "";
        for(int i=0; i<tree.size(); i++){
            output += i == 0 ? "" : "; ";
            for(int j=0; j<tree.get(i).size(); j++){
                output += (tree.get(i).get(j) + " ");
            }
        }

        System.out.println("Segment Tree is: \n" + output);
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,2,3,4,5};
        SegTree tree = new SegTree(test);
        tree.printTree();
        System.out.println("sum of 0-1: "+ tree.getSum(0,1));
        tree.update(5, 1);
        System.out.println("sum of 0-1: "+ tree.getSum(0,1));
        tree.printTree();
    }
}

class TreeNode{
    int val;
    int[] index;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, int lower, int upper){
        this.val = val;
        this.index = new int[2];
        this.index[0] = lower;
        this.index[1] = upper;
    }
}
