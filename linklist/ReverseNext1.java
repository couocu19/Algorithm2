package linklist;

public class ReverseNext1 {
    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        Construct.printList(head);
        reverse1(head);
        Construct.printList(head);

    }

    public static ListNode reverse1(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        if(head.next.next == null){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = null;
        while(cur!=null && cur.next!=null ){
            next = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = next;

            pre = cur;
            cur = next;
        }
        return head;
    }
}


