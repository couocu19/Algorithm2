package review.tree;

import java.util.HashMap;
import java.util.Map;

//根据二叉树前序和中序序列重建二叉树
public class BuildTRee {
    public static void main(String[] args) {


    }

}
class Solution105s {

    private Map<Integer,Integer> map = new HashMap<>();

    private int[] po;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.po = preorder;
        int len = preorder.length;
        for(int i =0;i<len;i++){
            map.put(inorder[i],i);
        }

        return build(0,0,len-1);




    }


    private TreeNode build(int preRoot,int inLeft,int inRight) {
        if (inLeft > inRight)
            return null;

        TreeNode tree = new TreeNode(po[preRoot]);
        int i = map.get(po[preRoot]);

        tree.left = build(preRoot + 1, inLeft, i - 1);
        tree.right = build(i - inLeft + preRoot + 1, i + 1, inRight);

        return tree;
    }

}
