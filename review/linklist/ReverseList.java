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


    //10.10  -- 带头结点的反转链表
    public static ListNode reverse1(ListNode head){
        if(head == null || head.next == null || head.next.next == null)
            return head;

        ListNode cur = head.next;
        head.next = null;
        ListNode next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
        return head;

    }

    //10.10-- 不带头节点的反转链表
    public static ListNode reverses1(ListNode head){
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
