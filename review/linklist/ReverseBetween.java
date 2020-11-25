package review.linklist;

public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        Construct.printList(head);
        Solution92 s = new Solution92();
        head = s.reverseBetween(head,2,4);
        Construct.printList(head);


    }
}

class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null|| head.next == null || m == n)
            return head;

        ListNode r = head;
        ListNode pre = null;
        for(int i =1;i<m;i++){
            pre = r;
            r = r.next;
        }
        ListNode start = r;
        for(int i = m;i<n;i++){
            r = r.next;
        }
        ListNode tail = r;
        ListNode tmpHead = tail.next;
        if(pre == null && tmpHead == null)
            return reverse(head);
        tail.next = null;
        ListNode newS = reverse(start);
        if(pre!=null) {
            pre.next = newS;
        }else{
            pre = new ListNode(0); //如果前驱为空，需要设置一个虚拟节点来连接后序结点
            pre.next = newS;
            head = pre.next;
        }
        start.next = tmpHead; //原前驱结点变为尾结点
        return head;
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