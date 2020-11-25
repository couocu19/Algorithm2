package review.linklist;

import java.util.List;

public class SpecialReverse {
    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        //Construct.printList(head);
        SpecialReverse sr = new SpecialReverse();
        ListNode h = sr.reverseK(head,3);
        Construct.printList(h);


    }

    public ListNode reverseK(ListNode head,int k){

        ListNode p = new ListNode(0);
        ListNode s = p;
       // ListNode cur = reverse(head);
        ListNode cur = head;
        p.next = cur;
        int i ;
        while(cur!=null){
            ListNode tmp = cur;
            for(i =0;i<(k-1) && cur!=null;i++) {
                cur = cur.next;
            }
            if(i<(k-1))
                break;
            ListNode next = null;
            if(cur!=null) {
                //先指定next指针
                next = cur.next;
                cur.next = null;  //将需要反转的部分结尾赋为空
                cur = tmp;
                tmp = reverse(tmp);
                cur.next = next;  //连接反转之后的链表和还未反转的链表
                s.next = tmp; //连接表头和整体的链表
                s = cur; //为下一次连接做准备
                cur = next;
            }

        }

        return p.next;
       // return  reverse(p.next);
    }

    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return null;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = null;
        pre.next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
