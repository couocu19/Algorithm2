package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IsValidBST {
    public static void main(String[] args) {
        Solution98s s = new Solution98s();
        int[] nums = {1,2,3,4,5,6,7,8,9,10};

        TreeNode root1 = ArrayToTree.arrayToTree1(nums,0, nums.length-1);

        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        node1.left = node1.right = node3.left
                   = node3.right = node4.left = node4.right =null;
        System.out.println(s.isValidBST(root));

    }
}


class Solution98 {
    private List<Integer> list = new ArrayList<>();
    private int flag = 0;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;

        isValidBST(root.left);
        list.add(root.val);

        if(list.size()>1&&root.val<list.get(list.size()-2)) {
            flag = 1;
            return false;
        }


        isValidBST(root.right);

            if(flag == 0) {
                return true;
            }else {
                return false;
            }




    }




}

class Solution98s {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                //System.out.println(root.val);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) return false;
            inorder = root.val;
            //System.out.print(inorder+" ");
            root = root.right;
            //System.out.println(root.val);
        }
        return true;
    }





}