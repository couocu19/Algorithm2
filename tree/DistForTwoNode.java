package tree;

import lanqiao.Tree;

import java.util.LinkedList;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

import static tree.FindParentNode.getParent1;

/**
 * 求二叉树任意两个结点之间的距离
 * 思路：首先求得这两个结点的最低公共父节点，然后利用公式可以求得距离：
 * Dist(n1,n2) = Dist(root,n1)+Dist(root,n2)-2*Dist(root,parent)
 */
public class DistForTwoNode {

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root;
        root = ArrayToTree.arrayToTree1(nums,0,nums.length-1);

        TreeNode node1 = root.left.left.left;
        TreeNode node2 = root.left.right;

        TreeNode res = null;
        res = getParent1(root,node1,node2);

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        Stack<TreeNode> s3 = new Stack<>();
        Dist(root,node1,s1);
        Dist(root,node2,s2);
        Dist(root,res,s3);
        System.out.println(s1.size());
        System.out.println(s2.size());
        System.out.println(s3.size());
        int dist = s1.size()+s2.size()-2*s3.size();
        System.out.println(dist);

    }


    public static boolean Dist(TreeNode root, TreeNode node, Stack<TreeNode> s){

        if(root == null)
            return false;

        if(root == node){
            s.push(root);
           return true;

        }

        //todo:加深理解一下
        if(Dist(root.left,node,s)|| Dist(root.right,node,s)){
            s.push(root);
            return true;
        }

        return false;

    }
}
