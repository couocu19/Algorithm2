package linklist;

//将单链表向右旋转k个位置
public class RotateK {
    public static void main(String[] args) {
        ListNode head = Construct.randomConstructor();
        Construct.printList(head);
        int k = 3;
        head = rotate(head,k);
        Construct.printList(head);

    }
    public static ListNode rotate(ListNode head,int k){
        ListNode cur = head.next;
        ListNode last = last(head);
        System.out.println(last.val);
        ListNode lastk1 = lastK(head,k);
        System.out.println(lastk1.val);
        head.next = lastk1.next;
        lastk1.next = null;
        last.next = cur;
        return head;

    }

    public static ListNode last(ListNode head){
        ListNode cur = head.next;
        while(cur!=null&&cur.next!=null){
            cur = cur.next;
        }
        return cur;
    }

    //找到倒数k+1个结点
    public static ListNode lastK(ListNode head,int k ){
        int i =0;
        ListNode fast = head.next;
        ListNode slow = head.next;
        for(i = 0;i<k&&fast!=null;i++){
            fast = fast.next;
        }
        if(i<k){
            return fast;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

}
