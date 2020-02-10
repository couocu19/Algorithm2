package linklist;

public class ReverseLinklist1 {

    public static void main(String[] args) {

    }


    //插入法逆置链表
    static ListNode reverseList1(ListNode head){

        ListNode cur = null; //当前节点
        ListNode next = null; //后继结点

        cur = head.next.next;
        head.next.next = null;

        while(cur!=null){
            next = cur.next;
            cur.next = head.next;
            head.next = cur;
            cur = next;
        }
        return head;
    }
}
