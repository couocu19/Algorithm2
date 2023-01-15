package top100;

import java.util.HashMap;
import java.util.Map;

public class No105 {

    public static void main(String[] args) {


    }
}

class Solution105 {
    int[] pr;
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        this.pr = preorder;
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildHelper(0,0,inorder.length-1);
    }
    private TreeNode buildHelper(int preN,int left,int right){
        if(left>right)
            return null;
        TreeNode root = new TreeNode(pr[preN]);
        int i = map.get(pr[preN]);
        root.left = buildHelper(preN+1,left,i-1);
        root.right = buildHelper(preN+i-left+1,i+1,right);
        return root;
    }
}