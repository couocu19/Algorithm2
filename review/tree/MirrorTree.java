package review.tree;

public class MirrorTree {
    public static void main(String[] args) {
        Solution27 s = new Solution27();
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t4.left = t4.right = t5.left = t5.right = t6.left = t6.right = null;

        PrintTree.printAsPre(t1);
        System.out.println();
        TreeNode tt = s.mirrorTree(t1);

        PrintTree.printAsPre(tt);



    }
}

class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode res = new TreeNode(root.val);
        res.left = mirrorTree(root.right);
        res.right = mirrorTree(root.left);

        return res;
    }
}