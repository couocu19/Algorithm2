package linklist;

public class AddTwoNumbers1 {
    public static void main(String[] args) {

    }

    static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode p = l1.next;
        ListNode q = l2.next;
        ListNode result = new ListNode();
        result.next = null;
        ListNode head = result;
        ListNode tmp = null;
        int sum = 0;
        int carry = 0;

        while(p!=null || q!=null){
            int x = p!=null?p.val:0;
            int y = q!=null?q.val:0;
            sum = x + y + carry;
            tmp = new ListNode(sum%10);
            carry = sum/10;
            head.next = tmp;
            head = tmp;

            if(p!=null){
                p = p.next;
            }
            if(q!=null){
                q = q.next;
            }
        }
        if(carry == 1){
            tmp = new ListNode(carry);
            head.next = tmp;
        }

        return result.next;
    }


}

