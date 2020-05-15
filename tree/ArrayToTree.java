package tree;



//把一个有序数组放到二叉树中
public class ArrayToTree {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("数组：");
        for(int a:arr){
            System.out.print(a+" ");
        }
        System.out.println();
        TreeNode root = arrayToTree1(arr,0,arr.length-1);
        System.out.println("二叉树：");
        PrintTree.printTreeMidTree(root);
        System.out.println();
        PrintTree.printTreePreTree(root);
        System.out.println();
        PrintTree.printTreeLasTree(root);




    }

    public static TreeNode arrayToTree(int[] arr,int start,int end) {

        TreeNode root = null;
        //这里的条件必须是大于等于
        if(end>=start){
            root = new TreeNode();
            int mid = (start+end)/2;
            root.val = arr[mid];
            //递归的用左半部分数组构造root的左子树
            root.left = arrayToTree(arr,start,mid-1);

            //递归的用右半部分数组构造root的右子树
            root.right = arrayToTree(arr,mid+1,end);
        }else{
            root = null;
        }

        return root;
    }


    public static TreeNode arrayToTree1(int[] arr,int start,int end){
        TreeNode root = null;
        if(end>=start){
            root = new TreeNode();
            int mid = (start+end+1)/2;
            //先赋值
            root.val = arr[mid];
            root.left = arrayToTree1(arr,start,mid-1);
            root.right = arrayToTree(arr,mid+1,end);

        }else{
            root = null;
        }

        return root;
    }




}


