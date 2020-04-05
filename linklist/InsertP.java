package linklist;

/**
 * 给定链表中的指定指针，在该指针前插入一个给定的新指针
 */
public class InsertP {
    public static void main(String[] args) {

        ListNode head = Construct.sortConstructor();
        Construct.printList(head);
        ListNode q = new ListNode(11);
        ListNode cur = head.next;
        int k = 5;
        int i = 1;
        while(cur!=null){
            cur = cur.next;
            if(i == k-1){
                break;
            }
            i++;
        }
        insert(cur,q);
        Construct.printList(head);


    }

    public static ListNode insert(ListNode p,ListNode q){
        int val = q.val;
        if(p == null || p.next == null){
            p.next = q;
            q.val = p.val;
            p.val = val;
            return p;
        }
        ListNode pNext = p.next;
        p.next = q;
        q.next = pNext;
        q.val = p.val;
        p.val = val;
        return p;
    }

}
