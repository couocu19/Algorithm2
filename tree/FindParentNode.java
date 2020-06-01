package tree;

import java.util.Stack;

//todo:复习之前的二叉树题型

public class FindParentNode {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root;
        root = ArrayToTree.arrayToTree1(nums,0,nums.length-1);

        TreeNode node1 = root.left.left.left;
        TreeNode node2 = root.left.right;

        TreeNode res = null;
        res = getParent(root,node1,node2);
        if(res!=null)
            System.out.println(node1.val+"与"+node2.val+"的最近公共父节点为"+res.val);
        else
            System.out.println("没有公共父节点");

    }

    /**
     * 函数功能:找出一个二叉树中任意两个节点之间的路径。
     * @param root 二叉树的根节点
     * @param node 二叉树中的指定结点
     * @param s 用来存放路径的栈
     * @return 当root结点和node结点相同或者路径中包含root结点的子节点时返回true，否则则返回false
     */
    public static boolean getPathFromRoot(TreeNode root, TreeNode node, Stack<TreeNode> s){
        if(root == null)
            return false;
        if(root == node){
            s.push(root);
            return true;
        }
        if(getPathFromRoot(root.left,node,s)
                || getPathFromRoot(root.right,node,s)){

            s.push(root);
            return true;
        }
        return false;

    }
    public static TreeNode getParent(TreeNode root,TreeNode node1,TreeNode node2){
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        getPathFromRoot(root,node1,s1);
        getPathFromRoot(root,node2,s2);

        TreeNode comment = null;
        while(s1.peek() == s2.peek()){
            comment = s1.peek();
            s1.pop();
            s2.pop();
        }
        return comment;
    }



}
