package review.tree;

public class IsSubTree {

    public static void main(String[] args) {



    }

    public boolean isSub(TreeNode t1,TreeNode t2){

        return (t1!=null &&t2!=null) &&(recur(t1,t2)||isSub(t1.left,t2)||isSub(t1.right,t2));

    }

    private boolean recur(TreeNode t1,TreeNode t2){
        if(t2 == null)
            return true;
        if(t1 == null || t1.val!=t2.val)
            return false;

        else
            return recur(t1.left,t2.left) && recur(t1.right,t2.right);

    }
}
