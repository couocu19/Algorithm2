package tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static void main(String[] args) {

    }
}

class SolutionA {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;

    }
    //递归实现二叉树的中序遍历
    public void helper(TreeNode root,List<Integer> list){
        if(root !=null){
            if(root.left !=null){
                helper(root.left,list);
            }
            list.add(root.val);
            if(root.right!=null){
                helper(root.right,list);
            }

        }


    }
}