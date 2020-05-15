package tree;

public class PrintTree {


    public static void printTreeMidTree(TreeNode root){
        if(root == null)
            return;
        if(root.left!=null)
            printTreeMidTree(root.left);
        System.out.print(root.val+" ");
        if(root.right!=null)
            printTreeMidTree(root.right);
    }

    public static void printTreePreTree(TreeNode root){
        if(root == null)
            return;
        System.out.print(root.val+" ");
        if(root.left!=null)
            printTreePreTree(root.left);
        if(root.right!=null)
            printTreePreTree(root.right);
    }

    public static void printTreeLasTree(TreeNode root){
        if(root == null)
            return;
        if(root.left!=null)
            printTreeLasTree(root.left);
        if(root.right!=null)
            printTreeLasTree(root.right);
        System.out.print(root.val+" ");

    }



}
