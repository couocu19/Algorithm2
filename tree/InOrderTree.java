package tree;

import java.util.jar.JarOutputStream;

/**
 * 将一颗二元查找树转为一个有序的双向链表
 */
public class InOrderTree {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        TreeNode root;
        root = ArrayToTree.arrayToTree(arr,0,arr.length-1);
        inOrderBSTree1(root);
        TreeNode cur ;
        System.out.println("转换后双向链表正向遍历：");
        for(cur = pHead;cur!=null;cur = cur.right){
            System.out.print(cur.val+" ");
        }
        System.out.println();

    }

    private static TreeNode pHead = null;
    private static TreeNode pEnd = null;

    public static void inOrderBSTree(TreeNode root){
        if(root == null)
            return;

        inOrderBSTree(root.left);

        root.left = pEnd;
        //若双向链表为空，当前遍历的结点为双向链表的头结点
        if(pEnd == null){
            pHead = root;
        }else{
            pEnd.right = root;
        }
        pEnd = root;
        inOrderBSTree(root.right);
    }

    public static void inOrderBSTree1(TreeNode root){
        if(root == null)
            return;
        inOrderBSTree(root.left);

        root.left = pEnd;
        if(pEnd == null){
            pHead = root;

        }else{
            pEnd.right = root;
        }

        pEnd = root;

        inOrderBSTree(root.right);


    }
}
