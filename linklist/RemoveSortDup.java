package linklist;


//删除排序链表的重复项
public class RemoveSortDup {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.next = null;
        ListNode cur = head;
        ListNode temp = null;
        for(int i =1;i<=10;i++){
            temp = new ListNode();
            if(i%2 == 0){
                temp.val = i-1;
            }else{
                temp.val = i;
            }
            temp.next = null;
            cur.next = temp;
            cur = temp;
        }
        System.out.println("删除重复项之前:");
        for(cur = head.next;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();
        remove(head);
        System.out.println("删除重复项之后:");
        for(cur = head.next;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }



    }

    public static ListNode remove(ListNode head){
        ListNode cur = head.next;
        ListNode curNext = null;

        for(;cur!=null;){
            curNext = cur.next;
            if(cur.val == curNext.val){
                cur.next = curNext.next;
                cur = cur.next;
            }else{
                cur = cur.next;
            }
        }

        return head;
    }

}
