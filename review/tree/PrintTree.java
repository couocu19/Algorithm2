package review.tree;

public class PrintTree {
    public static void printAsMid(TreeNode root){
        if(root!=null){
            if(root.left!=null)
                printAsMid(root.left);
            System.out.print(root.val+" ");
            if(root.right!=null)
                printAsMid(root.right);
        }

    }


    public static void printAsPre(TreeNode root){
        if(root!=null){

            System.out.print(root.val+" ");
            if(root.left!=null)
                printAsMid(root.left);
            if(root.right!=null)
                printAsMid(root.right);
        }

    }


    public static void printAsLes(TreeNode root){
        if(root!=null){
            if(root.left!=null)
                printAsMid(root.left);
            if(root.right!=null)
                printAsMid(root.right);

            System.out.print(root.val+" ");
        }

    }

    //获取一个二叉树的高度
    public static int getHigh(TreeNode root){
        if(root == null)
            return 0;
        int leftH = getHigh(root.left);
        int rightH = getHigh(root.right);

        return Math.max(leftH,rightH)+1;


    }







}
