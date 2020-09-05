package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackMidTraversal {

    public static void main(String[] args) {
        TreeNode head = ConstructorTree.construct();
       // PrintTree.printTreePreTree(head);

        Solution94 s = new Solution94();
        System.out.println(s.inorderTraversal(head));

        System.out.println(s.preorderTraversal(head));

        System.out.println(s.postorderTraversal(head));



    }
}


class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur!=null || !stack.empty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return res;
        }
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }

            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return res;
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();


        //prev结点用来区分之前的结点是否被访问过
        TreeNode prev = null;
        while(root!=null || !stack.empty()){
           if (root!=null){
                stack.push(root);
                root = root.left;

            }else {
                root = stack.peek();
                if (root.right == null || root.right == prev) {
                    root = stack.pop();
                    res.add(root.val);
                    //标记上一次访问节点
                    prev = root;
                    root = null;
                } else {
                    root = root.right;
                    stack.push(root);
                    root = root.left;
                }
            }
        }

        return res;

    }





    public List<Integer> inorderTraversal1(TreeNode root){
        TreeNode cur = root;
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while(cur!=null || !stack.empty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}