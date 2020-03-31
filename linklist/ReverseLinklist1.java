package linklist;

public class ReverseLinklist1 {

    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        Construct.printList(head);
        head = reverseList1(head);
        Construct.printList(head);

    }

    //插入法逆置链表
    static ListNode reverseList1(ListNode head){

        ListNode cur = null;
        ListNode next = null;

        cur = head.next.next;
        head.next.next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }


        return head;
    }
}
