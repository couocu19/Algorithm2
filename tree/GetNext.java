package tree;

public class GetNext {
    public static void main(String[] args) {



    }
}
class TreeLinkNode{
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode father;

}

class Solution08{

    //解题思路：大致可分为三种情况：当前节点有右子树；当前节点没有右子树且当前节点是他父节点的左子树；
    //当前节点没有右子树且当前节点时他父节点的右子树(这种情况比较复杂一些)
    public TreeLinkNode getNext(TreeLinkNode pNode){
        //首先判空
        if(pNode == null){
            return null;
        }

        //当前节点有右子节点
        TreeLinkNode curr = pNode;
        if(null!=pNode.right){
            curr = curr.right;
            while (curr.left!=null){
                curr = curr.left;
            }
            return curr;
            //当前节点没有右子节点
        }else{
            //去父节点中找，得到的结果一定一是个父节点
            while (curr.father!=null && curr == curr.father.right){
                curr = curr.father;
            }
            return curr.father;
        }


    }



    //todo:可以写一下得到前序，后序遍历的下一个元素
    public TreeLinkNode gerNext1(TreeLinkNode pNode){
        if(pNode == null)
            return null;
        TreeLinkNode cur = pNode;
        if(cur.right!=null){
            cur = cur.right;
            while (cur.left!=null){
                cur = cur.left;
            }
            return cur;
        }else{
            while (cur.father!=null && cur == cur.father.right){
                cur = cur.father;
            }
            return cur.father;
        }

    }




}