package review.linklist;

public class ReverseKGroup {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head,int k){
        ListNode tmp = head;
        for(int i =1;i<k&& tmp!=null;i++){
            tmp = tmp.next;
        }
        //判断结点的数量能否构成一组
        if(tmp == null)
            return head;

        ListNode t2 = tmp.next;
        tmp.next = null;
        //把当前的组进行逆序
        ListNode newHead = reverse(head);
        //把之后的结点进行分组逆序
        ListNode newTemp = reverseKGroup(t2,k);
        head.next = newTemp;
        return newHead;

    }


    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = null;
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


