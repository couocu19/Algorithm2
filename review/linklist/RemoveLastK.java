package review.linklist;

import tree.PrintTree;

import javax.sound.sampled.SourceDataLine;

public class RemoveLastK {
    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        Construct.printList(head);
        Solution19 s = new Solution19();
        int n = 3;
        Construct.printList(s.removeNthFromEnd(head,n));


    }
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null)
            return null;

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre;
        ListNode cur = pre;
        for(int i =0;i<n && fast!=null;i++){
            fast = fast.next;
        }

        while (fast.next!=null){
            cur = cur.next;
            fast = fast.next;
        }

            cur.next = cur.next.next;

        return pre.next;
    }
}