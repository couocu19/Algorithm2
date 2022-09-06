package top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No94 {
    public static void main(String[] args) {


    }
}

class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        List<Integer> list = new ArrayList<>();
        while (cur!=null || !stack.isEmpty()){
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




