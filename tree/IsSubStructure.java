package tree;


public class IsSubStructure {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t5.left = t6;
        t5.right = t7;
        t4.left = t4.right = t6.left = t6.right = t7.left = t7.right = t3.left = t3.right = null;


        TreeNode tt1 = new TreeNode(8);
        TreeNode tt2 = new TreeNode(8);
        TreeNode tt3 = new TreeNode(7);
        tt1.left = tt2;
        tt1.right = tt3;
        tt2.left = tt2.right = tt3.right = tt3.left = null;

        Solution26 s = new Solution26();
        System.out.println(s.isSubStructure1(t1,tt1));




    }


}

class Solution26 {
    public boolean isSubStructure1(TreeNode A, TreeNode B) {

        if(B == null)
            return true;
        if(A == null || A.val!=B.val)
            return false;


        if(A!=null && B!=null && A.val == B.val){
            boolean left = isSubStructure1(A.left, B.left);
            boolean right = isSubStructure1(A.right, B.right);
            return left&&right;

        }else{
            return isSubStructure1(A.left,B) ||isSubStructure1(A.right,B);
        }

    }

    //1.先序遍历树A中的每个节点
    //2.判断树A中以nA为根节点的子树是否包含树B（对应函数 recur(A,B)）
    public boolean isSubStructure(TreeNode A, TreeNode B){

        return (A!=null && B!=null) &&(recur(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B));
    }

    private boolean recur(TreeNode A,TreeNode B){
        if(B == null)
            return true;
        if(A == null || A.val!=B.val)
            return false;

        return recur(A.left,B.left) &&recur(A.right,B.right);
    }


}
class Solution26s {
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