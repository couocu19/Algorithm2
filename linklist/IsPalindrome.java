package linklist;

public class IsPalindrome {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(0);
        head1.next = n1;
        n1.next = null;
        n2.next = n3;
        n3.next = null;
        Solution234 s = new Solution234();
        System.out.println(s.isPalindrome(head1));


    }

}

class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;

        ListNode end1 = getMid(head);
        ListNode l2 = reverse(end1.next);
        boolean res = true;
        ListNode cur = head;
        while(res && l2!=null){
            if(cur.val != l2.val){
                res = false;
            }
            cur = cur.next;
            l2 = l2.next;
        }

        end1.next  = reverse(l2);

        return res;

    }

    private ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;


    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode cur = head.next;
        ListNode next = null;
        ListNode pre = head;
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