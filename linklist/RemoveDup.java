package linklist;


//删除无序链表中的重复项
public class RemoveDup {
    public static void main(String[] args) {
        int i = 1;
        ListNode head = new ListNode();
        head.next = null;
        ListNode temp = null;
        ListNode cur = head;
        for(;i<7;i++){
            temp = new ListNode();
            if(i%2 == 0){
                temp.val = i+1;
            }else if(i%3 == 0){
                temp.val = i-2;
            }else{
                temp.val = i;
            }
            temp.next = null;
            cur.next = temp;
            cur = temp;
        }
        System.out.println("删除重复结点前:");
        for(cur = head.next;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();
        removeDup(head);
        System.out.println("删除重复结点后:");
        for(cur = head.next;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }


    }


    public static ListNode removeDup(ListNode head){
        if(head == null){
            return null;
        }
        ListNode outerCur = head.next;
        ListNode innerCur = null;
        ListNode innerCurPre = null;
        ListNode temp = null;
        for(;outerCur!=null;outerCur = outerCur.next){
            for(innerCur=outerCur.next,innerCurPre=outerCur;innerCur!=null;){
                if(innerCur.val == outerCur.val){
                    innerCurPre.next = innerCur.next;
                    innerCur = innerCur.next;
                }else{
                    innerCurPre = innerCur;
                    innerCur = innerCur.next;
                }
            }
        }

        return head;
    }


}
