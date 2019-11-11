package tree2;

public class TreeTestall {
    public static void main(String[] args) {
        TreeNode R3 = new TreeNode(6,null,null);
        TreeNode R2 = new TreeNode(5,null,R3);
        TreeNode L2= new TreeNode(4,null,null);
        TreeNode R1 = new TreeNode(3,null,null);
        TreeNode L1 = new TreeNode(2,L2,R2);
        TreeNode T = new TreeNode(1,L1,R1);
        preOrder(T);

    }

    public static void preOrder(TreeNode root){
        if (root!=null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }

    }
}

class TreeNode{

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
