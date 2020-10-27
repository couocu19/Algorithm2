package review.linklist;

public class ReverseList1 {
    public static void main(String[] args) {



    }
}

class Solution24 {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode cur = head.next;
        ListNode pre = head;
        pre.next = null;
        ListNode next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}