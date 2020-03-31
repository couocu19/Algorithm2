package linklist;

public class ReverseClass {
    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        Construct.printList(head);
        //headReverse(head);
        head = noHeadReverse(head.next);
        System.out.print(head.val+" ");
        Construct.printList(head);
    }

    //带头结点逆置链表
    public static ListNode headReverse(ListNode head){
        ListNode cur = head.next.next;
        ListNode next = null;
        head.next.next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
        return head;

    }

    //不带头节点逆置链表
    public static ListNode noHeadReverse(ListNode head){
        ListNode cur = head.next;
        ListNode pre = head;
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
