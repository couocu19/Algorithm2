package review.linklist;

public class DeleteNode {

    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        Solution18 s = new Solution18();
        //System.out.println(s.deleteNode(head,5));
        Construct.printList(s.deleteNode(head,6));


    }
}


class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {

        if(head == null || head.next == null)
            return null;

        ListNode tmp = head;
        ListNode next;
        while (tmp!=null){
            next = tmp.next;
            if(next.next == null && next.val == val){
                tmp.next = null;
                break;
            }
            if(tmp.val == val){
                tmp.val = next.val;
                tmp.next = next.next;
                break;
            }
            tmp = tmp.next;
        }
        return head;

    }
}
