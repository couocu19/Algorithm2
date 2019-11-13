package tree;

public class MaxDepth1 {

    public static void main(String[] args) {


    }


}

class  Solution104{
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }

    }

}

