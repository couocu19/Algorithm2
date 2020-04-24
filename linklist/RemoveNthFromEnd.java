package linklist;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        Solution796 s = new Solution796();
        int n = 1;
        ListNode head = Construct.sortConstructor();
        Construct.printList(head);
        head = s.removeNthFromEnd(head,n);
        Construct.printList(head);

    }

}


class Solution796 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return null;
        //ListNode cur = head.next;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        ListNode fastCur = pre;

        while(n != 0) {
            fastCur = fastCur.next;
            n--;
        }

        while(fastCur.next!=null){
            cur = cur.next;
            fastCur = fastCur.next;
        }
          cur.next = cur.next.next;

        return pre.next;

    }
}