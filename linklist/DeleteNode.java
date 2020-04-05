package linklist;

//删除指定位置下的链表结点
public class DeleteNode {

    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        int k = 4;
        Construct.printList(head);
        delete(head,k);
        Construct.printList(head);


    }

    public static ListNode delete(ListNode head,int k){
        int i = 1;
        ListNode pre = null;
        ListNode cur = head.next;
        while(cur!=null){
            pre = cur;
            cur = cur.next;
            i++;
            if(i == k){
                pre.next = cur.next;
                break;
            }
        }

        return head;
    }


}
