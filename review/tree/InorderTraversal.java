package review.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {



    }
}


class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (cur!=null || !stack.empty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;

    }


    public List<Integer> inorderTraversal1(TreeNode root) {
        TreeNode cur = root;
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (cur!=null || !stack.empty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;


    }
}