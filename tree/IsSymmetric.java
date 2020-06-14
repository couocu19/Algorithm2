package tree;

public class IsSymmetric {
    public static void main(String[] args) {
        Solution101 s = new Solution101();
        TreeNode root = ConstructorTree.constructSymmetric();

        TreeNode root1 = ConstructorTree.construct();
        PrintTree.printTreePreTree(root);
        System.out.println();
        System.out.println(s.isSymmetric(root1));




    }
}

//判断一个二叉树是不是镜像对称二叉树
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        if(root.right == null && root.left == null)
            return true;

        if(root.left == null || root.right == null)
            return false;

        if(root.right.val!=root.left.val)
            return false;
        return flag(root.right,root.left);
    }

    private boolean flag(TreeNode node1,TreeNode node2){

        if(node1 == null && node2 == null)
            return true;

        if(node1 == null || node2 == null)
            return false;
        boolean outer = false;
        boolean inner = false;
        if(node1.val == node2.val){
            outer = flag(node1.left,node2.right);
            inner = flag(node1.right,node2.left);
        }

        return outer&&inner;


    }


}
