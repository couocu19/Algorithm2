package tree;

import lanqiao.Tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    public static void main(String[] args) {
        Solution230 s = new Solution230();
        int k = 2;
        TreeNode root = new TreeNode(3);
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(2);
        root.left = r1;
        root.right = r2;
        r1.right = r3;

        r1.left = r2.left = r2.right = r3.left = r3.right = null;
       // System.out.println(s.kthSmallest(root,k));

        Solution230s s1 = new Solution230s();
        System.out.println(s1.kthSmallest(root,k));




    }
}

class Solution230 {
    private final List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        toArray(root);
        return list.get(k-1);

    }

    private void toArray(TreeNode root){
        if(root.left!=null){
            toArray(root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            toArray(root.right);
        }

    }
}

class Solution230s{
    private int[] nums ;
    private int k;
    private int i = 0;

    public int kthSmallest(TreeNode root, int k) {
       this.k = k;
       nums = new int[k];

       toArray(root);
       return nums[k-1];

    }
    private void toArray(TreeNode root){
        if(i>=k)
            return;

        if(root.left!=null )
            toArray(root.left);
        if((i+1)<=k) {
            nums[i++] = root.val;
        }

        if(root.right!=null)
            toArray(root.right);

    }




}