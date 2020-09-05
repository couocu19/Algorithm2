package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackPostorderTraversal {
    public static void main(String[] args) {
        Solution145 s = new Solution145();
        TreeNode head = ConstructorTree.construct();
        System.out.println(s.postorderTraversal2(head));




    }
}

class Solution145{


    //后序遍历

    /**
     * 遍历思路：
     *    用一个栈保存访问到的节点，一直访问当前节点的左孩子，直到当前节点没有左孩子。
     *    如果当前节点已经没有左孩子，针对当前节点，此时会有两种情况：
     *       1.如果这个结点没有右孩子，或者当前节点的右孩子为上一个访问的结点，那么就访问当前节点，即将当前节点出栈并且加入到结果集中；
     *         需要注意的是，访问了该节点之后，需要将当前节点设置为已访问，即将当前节点标记为pre结点，并将当前节点置空；
     *       2.如果这个结点存在右孩子，那么就先不访问这个结点，而是访问当前节点的右孩子入栈。并遍历当前节点的右孩子的左孩子。
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        TreeNode pre = null;

        while (cur!=null || !stack.empty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.peek();
                if(cur.right == null || cur.right == pre){
                    cur = stack.pop();
                    res.add(cur.val);
                    pre = cur;
                    cur = null;
                }else{
                    cur = cur.right;
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }

        return res;
    }

    public List<Integer> postorderTraversal1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }

        }

     //   List<Integer> list = new ArrayList<>();


        return res;




    }

    /**
     * 遍历思路：
     *    首先将根节点入栈。
     *    在栈不为空时，首先弹出栈顶元素并加入到结果集中，并将其孩子节点从左到右依次加入到栈中。
     *    循环上面的动作。
     *    整个过程大致为：将二叉树的结点从上到下，从左到右加入到栈中遍历。
     *    对于结果集，输出的顺序和加入到结果集的顺序刚好相反，所以可以使用linkedlist来保存结果。
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            //将元素添加到链表的头部
            output.addFirst(node.val);

            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        //输出序列和添加序列正好相反
        return output;
    }




}


