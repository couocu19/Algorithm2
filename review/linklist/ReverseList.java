package review.linklist;


/**
 * 单链表的逆置
 */
public class ReverseList {
    public static void main(String[] args) {


        ListNode head = Construct.sortConstructor();
        Construct.printList(head);
        head = reverse(head);
        Construct.printList(head);

    }

    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null || head.next.next == null)
            return head;

        ListNode next = null;
        ListNode cur = head.next;

        head.next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }

        return head;

    }

}
