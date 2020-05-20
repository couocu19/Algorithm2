package tree;

public class FindMaxSubTree1 {

   // public static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = ConstructorTree.construct();
        TreeNode maxRoot = new TreeNode();
        System.out.println(find(root,maxRoot));
        System.out.println(maxRoot.val);



    }

    /**
     *
     * 根据二叉树的后续遍历来递归求得最大子树的和
     * @param root
     * @param maxRoot
     * @return
     */
    public static int find(TreeNode root,TreeNode maxRoot){
        if(root == null)
            return 0;

        int maxSum = Integer.MIN_VALUE;
        int lMax = find(root.left,maxRoot);
        int rMax = find(root.right,maxRoot);
        int sum = lMax+rMax+root.val;

        if(sum>maxSum){
            maxSum = sum;
            maxRoot.val = root.val;

        }
        return maxSum;

    }





}
