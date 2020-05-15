package tree;


//遍历求二叉树的最大深度
public class MaxDepth {
    public static void main(String[] args) {

    }
}

//DFS
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;

        }
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

      public TreeNode(){


      }
}
