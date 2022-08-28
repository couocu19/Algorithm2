package top100;

public class No2 {
    public static void main(String[] args) {


    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        res.next = null;
        ListNode tmp = res;
        int curSum;
        int p = 0;
        int q,a,b;
        while(l1!=null || l2!=null){
            a = (l1!=null)?l1.val:0;
            b = (l2!=null)?l2.val:0;
            curSum = a+b;
            q = curSum%10;
            tmp.next = new ListNode(q+p);
            p = curSum/10;
        }

        return res.next;
    }
}
