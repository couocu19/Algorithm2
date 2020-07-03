package review.linklist;

import java.util.List;

public class Add {

    public static void main(String[] args) {

    }

    public static ListNode add(ListNode l1,ListNode l2){
        ListNode p = l1.next;
        ListNode q = l2.next;

        ListNode result = new ListNode();
        ListNode head = result;
        ListNode temp = null;
        int carry = 0;
        while(p!=null || q!=null){
            int x = p!=null?p.val:0;
            int y = q!=null?q.val:0;
            int sum = x+y+carry;
            temp = new ListNode(sum%10);
            head.next = temp;
            head = temp;

            carry = sum/10;
            if(p!=null){
                p = p.next;
            }

            if(q!=null){
                q = q.next;
            }

        }

        if(carry == 1) {
            temp = new ListNode(carry);
            head.next = temp;

        }


        return result;

    }



}
