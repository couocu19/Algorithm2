package tree;

public class IsSubStructure {
    public static void main(String[] args) {



    }


}

class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if(A!=null && B!=null && A.val == B.val){
            boolean left = isSubStructure(A.left, B.left);
            boolean right = isSubStructure(A.right, B.right);
            return left&&right;

        }else{

            return isSubStructure(A.left,B) ||isSubStructure(A.right,B);
        }
        
    }
}