import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}

public class BinarySearchTree implements Iterable<Integer>{
    HashSet<Integer> set;
    TreeNode root;

    BinarySearchTree(){
        this.set = new HashSet<>();
    }

    @Override
    public Iterator<Integer> iterator(){
        List<Integer> list = new ArrayList<>();

        TreeNode p = this.root;
        Stack<TreeNode> stk = new Stack<>();
        while(p != null || !stk.isEmpty()){
            if(p!= null){
                stk.push(p);
                p = p.left;
            } else {
                TreeNode cur = stk.pop();
                list.add(cur.val);
                p = cur.right;
            }
        }
        return list.iterator();
    }

    public void add(int num){
        if(set.contains(num)){
            return;
        }
        root = addHelper(root, num);
    }

    private TreeNode addHelper(TreeNode root, int num){
        if(root == null){
            root = new TreeNode(num);
            set.add(num);
            return root;
        }

        if(root.val > num){
            root.left = addHelper(root.left, num);
        } else if(root.val < num){
            root.right = addHelper(root.right, num);
        }

        return root;
    }

    public int getNext(int num){
        if(!set.contains(num)){
            return -1;
        }

        TreeNode p = this.root;
        while(p.val != num){
            if(p.val > num){
                p = p.left;
            } else if(p.val < num){
                p = o.right;
            }
        }

        if(p.right == null) return -1;
        return p.right.val;
    }

    public int getPrev(int num){
        if(!set.contains(num)){
            return -1;
        }

        TreeNode p = this.root;
        while(p.val != num){
            if(p.val > num){
                p = p.left;
            } else if(p.val < num){
                p = o.right;
            }
        }

        if(p.left == null) return -1;
        return p.left.val;
    }

    // public static void main(String[] args) {
    //     BinarySearchTree bst = new BinarySearchTree();
    //     bst.add(3);
    //     bst.add(4);
    //     bst.add(1);

    //     Iterator<Integer> itr = bst.iterator();
    //     while(itr.hasNext()){
    //         System.out.print(" " + itr.next());
    //     }
    // }
    
}