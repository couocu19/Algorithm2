package linklist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode p = new ListNode();
        ListNode cur = null;
        ListNode head = p;
        for(int i =1;i<=3;i++)
        {
            cur = new ListNode(i,null);
            head.next = cur;
            head = cur;
            //System.out.println(cur.val);
        }
//        for(ListNode p1 = p.next;p1!=null;p1 = p1.next){
//            System.out.print(p1.val+" ");
//        }

        ListNode q = new ListNode();
        ListNode head1 = q;
        ListNode cur1 = null;
        for(int i =4;i<=6;i++){
            cur1 = new ListNode(i,null);
            head1.next = cur1;
            head1 = cur1;
        }
//        for(ListNode p1 = q.next;p1!=null;p1 = p1.next){
//            System.out.print(p1.val+" ");
//        }

        Solution2 s = new Solution2();
        ListNode d =  s.addTwoNumbers(p.next,q.next);

       for(ListNode p1 = d;p1!=null;p1 = p1.next){
            System.out.print(p1.val+" ");
        }



    }
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1[] = new int[15];
        int num2[] = new int[15];
        int num[] = new int[15];
        int i=0,j=0;
        ListNode p = l1;
        ListNode q = l2;
        ListNode result = null;
        ListNode s = result;
        while(p!=null){
          //  System.out.println(p.val);
            num1[i++] = p.val;
            //System.out.println(num1[i-1]);
            p = p.next;
        }
        System.out.println(i);
        for(int a:num1){
            System.out.println(a);
        }
        while(q!=null){
            num2[j++] = q.val;
            q = q.next;
        }
        int len = Math.max(i,j);
        for(int k = 0;k<len;k++){
            s.val+=num1[i--]+num2[j--];
            s.next.val = num[k]/10;
            s.val = num[k]%10;
            s = s.next;

        }
        return result;
    }
}