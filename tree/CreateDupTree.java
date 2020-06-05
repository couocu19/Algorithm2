package tree;

/**
 * 复制二叉树
 */
public class CreateDupTree {

    public static void main(String[] args) {
        TreeNode root = ConstructorTree.construct();


        PrintTree.printTreePreTree(getDup(root));



    }

    public static TreeNode getDup(TreeNode root){

        //注意：新的二叉树的结点要在函数体中定义
        TreeNode newRoot= new TreeNode();
        if(root == null)
            return null;

        newRoot.val = root.val;
        newRoot.left = getDup(root.left);
        newRoot.right = getDup(root.right);

        return newRoot;
    }

}
