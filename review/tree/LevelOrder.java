package review.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {



    }
}

class Solution {
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
        while (queue.size()>0){
            size = queue.size();
            list = new ArrayList<>();
            while (size!=0){
                TreeNode node = queue.poll();
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