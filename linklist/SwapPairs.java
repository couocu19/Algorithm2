package linklist;

import java.util.Stack;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode tmp = null;
        ListNode cur = head;
        //创建一个带有头结点的链表
        for(int i =1;i<=4;i++){
            tmp = new ListNode(i,null);
            cur.next = tmp;
            cur = tmp;
        }

        //遍历输出链表中内容
        for(ListNode p = head.next;p!=null;p = p.next){
            System.out.print(p.val+" ");
        }


        System.out.println();

      Solution24 s = new Solution24();
       s.swapPairs(head.next);

        //遍历输出链表中内容
        for(ListNode p = head;p!=null;p = p.next){
            System.out.print(p.val+" ");
        }
    }
}

class Solution24{
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p = new ListNode(-1);
        ListNode cur = head;
        head = p;
        while(cur!=null && cur.next!=null){
            //将两个结点放入栈中
            stack.add(cur);
            stack.add(cur.next);
            //当前节点往前走两步
            cur = cur.next.next;
            //从stack中弹出两个节点，然后用p结点指向新弹出的两个节点
            p.next = stack.pop();
            p = p.next;
            p.next = stack.pop();
            p = p.next;
        }
        //注意边界条件，当链表长度是奇数，cur就不为空
        if(cur!=null){
            p.next = cur;
        }else{
            p.next = null;
        }
        return head.next;
    }
}