package review.linklist;

public class Reverse1 {
    public static void main(String[] args) {


    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode cur = head.next;
        ListNode pre = head;
        ListNode next = null;
        pre.next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }


}
