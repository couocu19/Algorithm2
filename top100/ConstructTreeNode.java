package top100;

import java.util.Random;

public class ConstructTreeNode {
    public static TreeNode createRanTNode(){
        TreeNode root = new TreeNode();
        Random ran = new Random();
        root.val = ran.nextInt(10)+1;
        TreeNode flag = root;
        for(int i = 0;i<3;i++){
            int cur = ran.nextInt(10)+1;
            flag.left = new TreeNode(cur);
            cur = ran.nextInt(10)+1;
            flag.right = new TreeNode(cur);
            flag = flag.left;
        }
        return root;
    }

    public static TreeNode construct(){
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.right = node3.left = node4.left = node4.right = node5.left = node5.right
                =node6.left = node6.right = null;
        return root;
    }

    //二叉树前序遍历
    public static void printPreTree(TreeNode root){
        if(root == null)
            return;
        System.out.println(root.val);
        if(root.left!=null){
            printPreTree(root.left);
        }
        if (root.right != null) {
            printPreTree(root.right);
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

