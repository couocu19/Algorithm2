package two_principle;

public class HasCycle {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = head;

        Solution141 s = new Solution141();
        System.out.println(s.hasCycle(head));



    }
}


class Solution141 {
    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }

        return false;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }