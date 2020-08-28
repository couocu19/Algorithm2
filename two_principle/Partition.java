package two_principle;

public class Partition {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        Solution86 s = new Solution86();
        ListNode cur = s.partition1(head,3);
        ListNode temp = null;
       // System.out.println(1);
//        for(temp = cur;temp !=null;temp = temp.next){
//            System.out.println(temp.val);
//        }

    }

}
class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(x);
        ListNode temp = head;
        ListNode pre = new ListNode(0);
        ListNode las = newHead;
        ListNode res = null;
        int flag = 0;
        ListNode cur = null;
        for(temp = head;temp!=null;temp = temp.next){
            cur = new ListNode(temp.val);
            if(cur.val == x)
                continue;
            if(cur.val <x){
                if(flag == 0){
                    res = cur;
                    flag = 1;
                }
                cur.next = newHead;
                pre.next = cur;
                pre = cur;
            }else{
                las.next = cur;
                las = cur;
            }
        }

        return res;
    }

    public ListNode partition1(ListNode head, int x){
        ListNode before = new ListNode(0);
        ListNode h1 = before;
        ListNode after = new ListNode(0);
        ListNode h2 = after;

        ListNode tmp = head;
        while(tmp!=null){
            if(tmp.val<x){
                before.next = tmp;
                before = tmp;
            }else{
                after.next = tmp;
                after = tmp;
            }

            tmp = tmp.next;
        }


       // System.out.println(after.next.val);
        //注意：这里要将after.next置为空，因为after.next的接的是原链表的值。
        after.next = null;

        before.next = h2.next;

        return h1.next;

    }

    public ListNode partition2(ListNode head, int x){
        ListNode before = new ListNode(0);
        ListNode h1 = before;

        ListNode after = new ListNode(0);
        ListNode h2 = after;

        ListNode tmp = head;
        while (tmp != null) {
            if(tmp.val<8){
                before.next = tmp;
                before = tmp;
            }else{
                after.next = tmp;
                after = tmp;
            }
            tmp = tmp.next;
        }
        after.next = null;
        before.next = h2.next;

        return h1.next;



    }
}