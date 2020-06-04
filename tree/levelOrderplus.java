package tree;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderplus {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        //TreeNode node5 = new TreeNode();
        root.left = node1;
        root.right = node2;
        node1.right = node1.left = node3.right = node3.left
                    = node4.right = node4.left = null;
        node2.left = node3;
        node2.right = node4;

        Solution102s s = new Solution102s();
        //TreeNode root = ConstructorTree.construct();
        System.out.println(s.levelOrder(null));



    }


}

class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list ;
        int high = getHigh(root);
        for(int i =0;i<high;i++){
            list = new ArrayList<>();
            getLevel(root,i,list);
            result.add(list);
        }
        return result;
    }

    private int getHigh(TreeNode root){
        if(root == null)
            return 0;

        int left = getHigh(root.left);
        int right = getHigh(root.right);
        return Math.max(left,right)+1;

    }

    private int getLevel(TreeNode root,int level,List<Integer> list){

        if (root == null || level<0)
            return 0;

        if (level==0){
            list.add(root.val);
            return 1;
        }
        else
            return getLevel(root.left,level-1,list)+getLevel(root.right,level-1,list);

    }
}

class Solution102s{

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        result.add(list);
        int size;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode node ;

        while(queue.size()>0){
            size = queue.size();
            list = new ArrayList<>();
            while(size!=0){
                node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                    list.add(node.left.val);
                }

                if(node.right!=null){
                    queue.offer(node.right);
                    list.add(node.right.val);
                }
                size--;
            }
                result.add(list);
        }

        result.remove(result.size()-1);
        return result;





    }


}
