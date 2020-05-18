package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 方法功能：用层序的方式打印二叉结点的内容
 * 输入参数:root:二叉树的根节点
 */
public class PrintTreeLayer {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root = ArrayToTree.arrayToTree2(arr,0,arr.length-1);
        printTreeLayer1(root);
        System.out.println();

        System.out.println(getHigh(root,0));
        int h = getHigh(root,0);
        for(int i =0;i<h;i++){
            printAtLevel(root,i);
        }

    }

    //思路：根据队列先进先出的特点来实现
    public static void printTreeLayer(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null)
            return;
        TreeNode p;
        queue.offer(root);
        while(queue.size()>0){
            //当前结点出队列
            p = queue.poll();
            //打印当前结点
            System.out.print(p.val+" ");
            if(p.left!=null)
                queue.offer(p.left);
            if(p.right!=null)
                queue.offer(p.right);
        }



    }

    public static void printTreeLayer1(TreeNode root){
        if(root == null)
            return;
        TreeNode p = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size()>0){
            p = queue.poll();
            System.out.print(p.val+" ");
            if(p.left!=null)
                queue.offer(p.left);
            if(p.right!=null)
                queue.offer(p.right);
        }

    }

    //用空间复杂度为O(1)的算法来实现层序遍历
    //前提需要计算出二叉树的高度

    //主要算法思路：不使用队列来存储每一层遍历到的结点，而是每次都会从根节点开始遍历。
    //把遍历二叉树的第k层结点转为遍历二叉树根节点的左右子树的第(k-1)层结点
    public static int printAtLevel(TreeNode root,int level){
        if(root == null || level<0){
            return 0;
        }
        else if(level == 0){
            System.out.println(root.val);
            return 1;
        }
        else
            return printAtLevel(root.left,level-1)+printAtLevel(root.right,level-1);
    }



    public static int getHigh(TreeNode root,int high){
        if(root == null)
            return 0;

        while(root.left!=null || root.right!=null){
          //  System.out.println("o");
            if(root.left!=null){
                return getHigh(root.left,high+1);
            }else if(root.right!=null){
                return getHigh(root.right,high+1);
            }

        }
        return high;

    }

}
