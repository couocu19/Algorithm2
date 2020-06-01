package tree;

import java.util.Stack;

public class FindParentNode {
    public static void main(String[] args) {



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
    public TreeNode getParent(TreeNode root,TreeNode node){
        Stack<TreeNode> s1 = null;
        Stack<TreeNode> s2 = null;

        getPathFromRoot(root,node,s1);
        getPathFromRoot(root,node,s2);

        TreeNode comment = null;
        while(s1.peek() == s2.peek()){

            comment = s2.peek();
            s1.pop();
            s2.pop();
        }
        return comment;
    }



}
