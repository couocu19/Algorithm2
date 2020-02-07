package linklist;

public class AddTwoNumbers3 {

    public static void main(String[] args) {


    }
}

class Solution2s {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        int sum = 0;
        ListNode result = new ListNode(0);
        ListNode r = result;
        ListNode r1;

        while(p!=null || q!=null){
            int x = p == null?0:p.val;
            int y = q == null?0:q.val;
            sum = carry + x + y;
            carry = sum/10;
            r1 = new ListNode(sum%10);
            r.next = r1;
            if(p!=null){
                p = p.next;
            }
            if(q!=null){
                q = q.next;
            }
        }

        if (carry > 0) {
            r.next = new ListNode(carry);
        }
        return result.next;




    }
}

