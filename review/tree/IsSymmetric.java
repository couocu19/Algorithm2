package review.tree;

public class IsSymmetric {
    public static void main(String[] args) {



    }
}
class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true:recur(root.left,root.right);

    }

    private boolean recur(TreeNode L,TreeNode R){
        if(L == null && R == null)
            return true;

        if(L == null || R == null || L.val!=R.val)
            return false;

        return recur(L.left,R.right) && recur(L.right,R.left);

    }
}

class Solution28s {
    public boolean isSymmetric(TreeNode root) {

        return root == null?true:recur(root.left,root.right);
    }


    private boolean recur(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null || t1.val!=t2.val)
            return false;

        return recur(t1.left,t2.right) && recur(t1.right,t1.left);

    }



}