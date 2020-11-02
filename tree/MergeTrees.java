package tree;

public class MergeTrees {
    public static void main(String[] args) {
        TreeNode t1 = ConstructorTree.construct();
        TreeNode t2 = ConstructorTree.construct();

        PrintTree.printTreePreTree(t1);
        System.out.println();
        PrintTree.printTreePreTree(t2);
        System.out.println();
        Solution617 s = new Solution617();
        PrintTree.printTreePreTree(s.mergeTrees(t1,t2));

    }
}


class Solution617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;

        TreeNode merge = new TreeNode(t1.val+t2.val);
        merge.left = mergeTrees(t1.left,t2.left);
        merge.right = mergeTrees(t1.right,t2.right);

        return merge;

    }
}