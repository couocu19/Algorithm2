package review.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTree1 {
    public static void main(String[] args) {


    }
}


class Solution105 {
    Map<Integer,Integer> map;
    private int[] pr;

    //将中序遍历中的序列以及对应的下标存到一个map中，便于在确定root的时候确定位置，然后可以根据root的位置确定左右子树的下标
    //总体思路：在中序遍历中定位到根节点，由于同一颗子树的前序遍历和中序遍历的长度相同，可以对应到前序遍历的结果中
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.pr = preorder;
        int len = preorder.length;
        map = new HashMap<>();
        for(int i =0;i<len;i++){
            map.put(inorder[i],i);
        }
        return build(0,0,len-1);
    }

    private TreeNode build(int preRoot,int left,int right){
        if(left>right)
            return null;

        TreeNode root = new TreeNode(pr[preRoot]);
        int i = map.get(pr[preRoot]);
        //分别得到左右子树的前序序列下的根节点和 左右子树之间的长度差值，即从(left到right)，其中left为中序序列中的左边界，right为有边界
        root.left = build(preRoot+1,left,i - 1);
        root.right = build(i-left+preRoot+1,i + 1,right);

        return root;
    }

}
