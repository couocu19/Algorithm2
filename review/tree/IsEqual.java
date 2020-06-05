package review.tree;


public class IsEqual {
    public static void main(String[] args) {
        TreeNode node1 = ConstructorTree.construct();
        TreeNode node2 = ConstructorTree.construct();

        System.out.println(isEqual(node1,node2));



    }

    public static boolean isEqual(TreeNode node1,TreeNode node2){
        if(node1 == null && node2 == null)
            return true;

        if(node1 ==null || node2 == null)
            return false;

        if(node1.val == node2.val){
            return isEqual(node1.left,node2.left) && isEqual(node1.right,node2.right);
        }
        return false;
    }

}
