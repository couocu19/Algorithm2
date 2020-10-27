package review.linklist;

public class DetectCycle {
    public static void main(String[] args) {



    }
}

class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode cur = head;
        ListNode fast = cur;
        ListNode slow = cur;
        while (true){
            if(fast == null ||fast.next==null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                break;
            }
        }

        fast = head;

        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }



}