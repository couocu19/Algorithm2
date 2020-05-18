package tree;

public class FindMaxSubTree {
    public static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {

        TreeNode root = constructTree();
        TreeNode maxRoot = new TreeNode();
        findMaxSubTree(root,maxRoot);
        System.out.println("最大子树和为："+maxSum);
        System.out.println("对应子树的根节点为："+maxRoot.val);

    }

    public static int findMaxSubTree(TreeNode root,TreeNode maxRoot){
        if(root == null){
            return 0;
        }
        int lMax = findMaxSubTree(root.left,maxRoot);
        int rMax = findMaxSubTree(root.right,maxRoot);
        int sum = lMax+rMax+root.val;

        if(sum>maxSum){
            maxSum = sum;
            maxRoot.val = root.val;
        }
        return sum;
    }

    public static TreeNode constructTree(){
        TreeNode root = new TreeNode();
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();
        TreeNode node3 = new TreeNode();
        TreeNode node4 = new TreeNode();

        root.val = 6;
        node1.val = 3;
        node2.val = -7;
        node3.val = -1;
        node4.val = 9;

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node2.right = node3.left = node3.right = node4.left = node4.right = null;

        return root;
    }



}
