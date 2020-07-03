package review.linklist;

public class FindLastK {
    public static void main(String[] args) {


    }

    public ListNode findLK(ListNode head,int k){

        ListNode cur = head.next;
        ListNode fast = head.next;

        int i;
        for(i =0;i<k&&fast!=null;i++){
            fast = fast.next;
        }

        if(i<k){
            return fast;
        }

        while(fast!=null){
            fast = fast.next;
            cur = cur.next;
        }

        return cur;




    }



}
