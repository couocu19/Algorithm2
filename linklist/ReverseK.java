package linklist;

//把链表以k个结点为一组进行翻转
public class ReverseK {
    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        int k =3;
        Construct.printList(head);
        reverseK(head,k);
        Construct.printList(head);

    }

    //todo:明天再消化一次
    public static ListNode reverseK(ListNode head,int k){
        int i =1;
        ListNode cur = head.next;
        ListNode reverseCur = head.next;
        ListNode next = null;
        ListNode pre = head;
        pre.next = null;
        while(cur!=null){
            next = cur.next;
            if(i == k){
                cur.next = null;
                pre.next = ReverseClass.noHeadReverse(reverseCur);
                i = 1;
                pre = reverseCur;
                cur = next;
                reverseCur = cur;
                pre.next = reverseCur;
            }

            try {
                cur = cur.next;
                i++;
            } catch (Exception e) {
                break;
            }

        }

        return head;
    }

}
