package tree;

import java.util.ArrayList;
import java.util.List;

public class FindRoad {
    public static void main(String[] args) {

        TreeNode root = constructTree();
        int num = 7;
        List<Integer> list = new ArrayList<>();
        findRoad(root,num,0,list);

    }


    public static void findRoad(TreeNode root, int num, int sum, List<Integer> list){
        sum+=root.val;
        list.add(root.val);

        if(sum == num && root.left == null && root.right == null){
            System.out.println(list);
            System.out.println();
        }

        if(root.left!=null) {
            findRoad(root.left, num, sum, list);
        }

        if(root.right!=null) {
            findRoad(root.right, num, sum, list);
        }

        //清除当前遍历的路径
        //感觉这个也类似于回溯算法
        sum-=list.get(list.size()-1);
        list.remove(list.size()-1);

    }

    public static TreeNode constructTree(){
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(-7);
        TreeNode node3 = new TreeNode(-1);
        TreeNode node4 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        node2.right = node2.left = node3.left = node3.right
                    = node4.left = node4.right = null;

        return root;
    }
}
