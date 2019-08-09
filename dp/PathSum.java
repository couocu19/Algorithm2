package dp;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public static void main(String[] args) {

    }
}

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root,sum,res,new ArrayList<Integer>());
        return res;
    }
    private void helper(TreeNode root,int sum,List<List<Integer>> res,ArrayList<Integer> tmp){
        if(root == null)
            return;
        tmp.add(root.val);

        if(root.left == null && root.right == null && sum - root.val ==0)
            res.add(new ArrayList<>(tmp));

        helper(root.left,sum - root.val,res,tmp);
        helper(root.right,sum - root.val,res,tmp);
        //如果左右节点都找不到，就移除当前节点，由于java是引用传递，所以要将当前节点移除。
        tmp.remove(tmp.size() - 1);

    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
