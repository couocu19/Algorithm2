package top100;

public class No19 {
    public static void main(String[] args) {
        Solution19 s = new Solution19();
        ListNode l = ConstructList.sortConstructor();
        ConstructList.printList(l);
        int n = 1;
        l = s.removeNthFromEnd(l,n);
        ConstructList.printList(l);


    }
}


class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        ListNode tmp = head;
        ListNode tmp1 = head;
        int i;
        for(i = 0;i<n && tmp.next!=null;i++){
            tmp = tmp.next;
        }
        while(tmp.next!=null){
            tmp = tmp.next;
            tmp1 = tmp1.next;
        }

        tmp1.next = tmp1.next.next;

        return head;
    }
}