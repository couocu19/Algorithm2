package review.linklist;

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
    public static TreeLinkNode getMidNext(TreeLinkNode node){
        if(node == null)
            return null;

        TreeLinkNode cur = node;

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

            return cur;
        }
    }

    //todo:测试
    public static TreeLinkNode getPreNext(TreeLinkNode node){
        if(node == null)
            return null;
        TreeLinkNode cur = node;
        if(cur.left == null && cur.right == null && cur.father == null)
            return null;
        if(cur.left!=null){
            cur = cur.left;
            return cur;
        }else if(cur.right!=null){
            cur = cur.right;
            return cur;
        }else {
            if(cur == cur.father.right){
                cur = cur.father;
            }
                while (cur.father != null) {
                    cur = cur.father;
                    if (cur.right != null) {
                        cur = cur.right;
                        break;
                    }
                }
                //遇到最后一个元素情况
                if (cur.right == null) {
                    return null;
                }
                return cur;
            }
        }


    //todo:测试
    public static TreeLinkNode getLasNode(TreeLinkNode node) {
        if(node == null)
            return null;

        TreeLinkNode cur = node;

        //根节点已经是最后一个元素
        if(cur.father == null)
            return null;

        if(cur == cur.father.right){
            cur = cur.father;
            return cur;
        }else{
            cur = cur.father;
            if(cur.right == null){
                return cur;
            }else{
                cur = cur.right;
                if(cur.left == null && cur.right == null)
                    return null;
                else{
                    while (cur.left!=null || cur.right!=null){
                        cur = cur.left!=null?cur.left:cur.right;
                    }
                    return cur;
                }
            }
        }
    }





}



