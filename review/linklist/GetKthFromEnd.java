package review.linklist;

public class GetKthFromEnd {
    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        int k = 2;
        Solution22 s = new Solution22();

        Construct.printList(head);
        Construct.printList(s.getKthFromEnd(head,k));


    }


}

class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null)
            return head;
        ListNode cur = head;
        ListNode fast = cur;
        int i;
        for(i = 0;i < k && fast!=null;i++){
            fast = fast.next;
        }

        if(i<k){
            return head;
        }
        while (fast!=null){
            cur = cur.next;
            fast = fast.next;

        }
        return cur;

    }
}