package review.tree;

import lanqiao.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//逐层打印二叉树
public class PrintTreeLayer {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root = ArrayToTree.arrayToTree(nums,0,nums.length-1);
        printLayer(root);

        System.out.println();

        int h = PrintTree.getHigh(root);
        for(int i =0;i<h;i++){
            printLayer1(root,i);
        }
    }

    public static void printLayer(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while(queue.size()>0){
            node = queue.poll();
                System.out.print(node.val + " ");

            if(node.left!=null)
                queue.offer(node.left);
            if(node.right!=null)
                queue.offer(node.right);
        }

    }

    public static int printLayer1(TreeNode root,int level){
        if(root == null || level<0)
            return 0;
        if(level == 0){
            System.out.print(root.val+" ");
            return 1;
        }else{
            return printLayer1(root.left,level-1)+printLayer1(root.right,level-1);
        }
    }



}
