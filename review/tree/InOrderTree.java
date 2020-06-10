package review.tree;

/**
 * 将二元查找树转为一个排序的双向链表
 */
public class InOrderTree {
    public static void main(String[] args) {


    }

    private static TreeNode pHead = null;
    private static TreeNode pEnd = null;

    public static void inOrderTree(TreeNode root){

        if(root == null)
            return;
        inOrderTree(root.left);
        root.left = pEnd;
        //若双向链表为空，当前遍历的结点为双向链表的头结点
        if(pEnd == null){
            pHead = root;
        }else{
            pEnd.right = root;
        }
        pEnd = root;
        inOrderTree(root.right);
    }

}
