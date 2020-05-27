package tree;

public class isEqual {

    public static void main(String[] args) {
        TreeNode n1 = ConstructorTree.construct();
        TreeNode n2 = ConstructorTree.construct();
        System.out.println(isEqual(n1,null));



    }

    public static boolean isEqual(TreeNode n1,TreeNode n2){
        if(n1 == null && n2 == null)
            return true;
        if(n1 == null || n2 == null)
            return false;

        if(n1.val == n2.val)
            return isEqual(n1.left,n2.left) && isEqual(n1.right,n2.right);
        else
            return false;
    }
}
