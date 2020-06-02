package review.tree;

public class ArrayToTree {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root = arrayToTree(nums,0,nums.length-1);
        PrintTree.printAsMid(root);
        System.out.println();
        System.out.println(PrintTree.getHigh(root));

    }

    //把一个有序的整数数组放到一个二叉树中
    //要求中序遍历该二叉树的序列和数组的序列一样
    public static TreeNode arrayToTree(int[] arr,int start,int end){
        TreeNode root = null;
        int mid ;

        //这里的判断条件是if  不是while
        if(start<=end){
            root = new TreeNode();
            mid = (start+end+1)/2;
            root.val = arr[mid];
            root.left = arrayToTree(arr,start,mid-1);
            root.right = arrayToTree(arr,mid+1,end);
        }else {
            root = null;
        }


        return root;


    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    public TreeNode(){

    }
}
