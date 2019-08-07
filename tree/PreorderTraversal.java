package tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public static void main(String[] args) {

    }
}

class SolutionB {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list1 = new ArrayList<>();
        help1(root,list1);

        return list1;
    }

    //递归算法实现二叉树的前序遍历
    public void help1(TreeNode root,List<Integer> list1){
        if(root!=null){
            list1.add(root.val);
            if(root.left!=null){
                help1(root.left,list1);
            }
            if(root.right!=null){
                help1(root.right,list1);
            }

        }

    }
}