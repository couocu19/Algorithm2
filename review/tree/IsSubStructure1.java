package review.tree;

public class IsSubStructure1 {
    public static void main(String[] args) {


    }
}

class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B){

        return (A!=null && B!=null) && (recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));



    }


    private boolean recur(TreeNode A,TreeNode B){
        if(B == null)
            return true;
        if(A == null || A.val!=B.val)
            return false;

        return recur(A.left,B.left) && recur(A.right,B.right);

    }





}