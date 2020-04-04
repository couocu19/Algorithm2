package linklist;


//合并两个有序链表
public class MergeList {
    public static void main(String[] args) {
        ListNode h1 = Construct.sortConstructor();
        ListNode h2 = Construct.sortConstructor();
        ListNode head = merge(h1,h2);
        Construct.printList(head);


    }

    public static ListNode merge(ListNode h1,ListNode h2){
        ListNode cur1 = h1.next;
        ListNode cur2 = h2.next;
        ListNode head = null;
        if(cur1.val<cur2.val){
            head = h1;
        }else{
            head = h2;
        }
        ListNode temp = null;
        ListNode cur = head;
        while(cur1!=null && cur2!=null){
            if(cur1.val<cur2.val){
                temp = cur1;
                cur.next = temp;
                cur = temp;
                cur1 = cur1.next;
            }else{
                temp = cur2;
                cur.next = temp;
                cur = temp;
                cur2 = cur2.next;
            }

        }
        if(cur2 ==null){
            cur.next = cur1;

        }

        if(cur1 == null){
            cur.next = cur2;


        }

        return head;
    }

}
