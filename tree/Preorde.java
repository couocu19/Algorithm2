package tree;

import java.util.ArrayList;
import java.util.List;

public class Preorde {
    public static void main(String[] args) {

    }
}

class SolutionD {
    public List<Integer> preorder(Node root) {
        List<Integer> list3 = new ArrayList<>();
        help3(root,list3);

        return list3;

    }

    //递归算法实现N叉树的前序遍历
    public void help3(Node root,List<Integer> list3){
        if(root!=null){
            list3.add(root.val);
            if(root.children!=null) {
                for (Node node : root.children) {
                    help3(node, list3);
                }
            }
        }
    }
}

//普通树的结构
class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}