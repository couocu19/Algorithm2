package tree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public static void main(String[] args) {

    }
}

class SolutionC {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list2 = new ArrayList<>();
        help2(root,list2);
        return  list2;

    }
    //递归算法实现二叉树的后序遍历
    public void help2(TreeNode root,List<Integer> list2){
        if(root!=null){
            if(root.left!=null){
                help2(root.left,list2);
            }
            if(root.right!=null){
                help2(root.right,list2);
            }
            list2.add(root.val);

        }
    }
}
