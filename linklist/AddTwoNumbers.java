package linklist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode p = new ListNode();
        ListNode cur = null;
        ListNode head = p;
        for(int i =5;i<=6;i++)
        {
            cur = new ListNode(i,null);
            head.next = cur;
            head = cur;
        }

        ListNode q = new ListNode();
        ListNode head1 = q;
        ListNode cur1 = null;
        for(int i =2;i<=4;i++){
            cur1 = new ListNode(i,null);
            head1.next = cur1;
            head1 = cur1;
        }
        Solution2s s = new Solution2s();
        ListNode d =  s.addTwoNumbers(p.next,q.next);


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
        ListNode result = new ListNode();
        result.next = null;
        ListNode s = result;
        ListNode s1 ;
        while(p!=null){
            num1[i++] = p.val;
            p = p.next;
        }
        while(q!=null){
            num2[j++] = q.val;
            q = q.next;
        }
        int len = Math.max(i,j);
        for(int k = 0;k<len+1;k++){
            num[k] += num1[k]+num2[k];
            num[k+1] = num[k]/10;
            num[k] = num[k]%10;
        }
        if(num[len]!=0){
            len++;
        }
        for(int l = 0;l<len;l++){
            System.out.println(num[l]);
        }

        for(int k = 0;k<len;k++){
          s.val = num[k];
          System.out.println(s.val);
          s1 = new ListNode();
          s.next = s1;
          s = s1;
        }

        for(ListNode p1 = result;p1!=null;p1 = p1.next){
            System.out.print(p1.val);
        }

        return result;
    }
}