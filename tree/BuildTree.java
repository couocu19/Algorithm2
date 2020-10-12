package tree;

import lanqiao.Tree;
import string.Transfer;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public static void main(String[] args) {



    }
}

class Solution07 {
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        po = preorder;
        int len = preorder.length;
        for(int i =0;i<len;i++){
            map.put(inorder[i],i);
        }

        return build(0,0,inorder.length-1);

    }

    private TreeNode build(int preRoot, int inLeft, int inRight){
        if(inLeft>inRight)
            return null;

        TreeNode root = new TreeNode(po[preRoot]);

        int i = map.get(po[preRoot]);
        root.left = build(preRoot+1,inLeft,i-1);

        //右子树：根节点索引为： 根节点索引＋左子树长度+1
        root.right = build(preRoot+i-inLeft+1,i+1,inRight);

        return root;
    }
}

class Solution07s {
    Map<Integer,Integer> map = new HashMap<>();
    int[] po;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        po = preorder;
        int len = preorder.length;
        for(int i =0;i<len;i++){
            map.put(inorder[i],i);
        }

        return build(0,0,len-1);


    }

    private TreeNode build(int preRoot,int inLeft,int inRight){

        if(inLeft>inRight)
            return null;
        TreeNode tree = new TreeNode(po[preRoot]);
        int i = map.get(po[preRoot]);

        tree.left = build(preRoot+1,inLeft,i-1);

        //注意右子树的根节点的下标计算
        tree.right = build(i-inLeft+preRoot+1,i+1,inRight);
        return tree;
    }

}


