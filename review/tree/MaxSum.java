package review.tree;

import java.util.jar.JarOutputStream;

public class MaxSum {
    public static void main(String[] args) {

        TreeNode root  = ConstructorTree.construct();

        TreeNode maxRoot = new TreeNode();
        System.out.println(getMax(root,maxRoot));
        System.out.println(maxRoot.val);


    }

    /**
     *
     * 要求：返回二叉树的最大子树的和
     * 思路：二叉树后序遍历的变形
     * @param root 二叉树的根节点
     * @param maxRoot 二叉树最大子树的父节点
     * @return
     */
    public static int getMax(TreeNode root,TreeNode maxRoot){

        int max = Integer.MIN_VALUE;

        if(root == null)
            return 0;

        int lMax =  getMax(root.left,maxRoot);
        int rMax = getMax(root.right,maxRoot);
        int sum = lMax+rMax+root.val;
        if(sum>max){
            max = sum;
            maxRoot.val = root.val;
        }

      //  System.out.println(maxRoot.val);
        return max;

    }
}
