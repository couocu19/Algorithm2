package review.linklist;



public class RemoveDup {
    public static void main(String[] args) {



    }


    ListNode remove(ListNode head){
        ListNode outCur = head.next;
        ListNode innerCur = null;
        ListNode innerPre = null;
        for(;outCur!=null;outCur = outCur.next) {
            for(innerCur = outCur.next,innerPre = outCur;innerCur!=null;){
                if(innerCur.val == outCur.val){
                    innerPre.next = innerCur.next;
                    innerCur = innerCur.next;
                }else{
                    innerPre = innerCur;
                    innerCur = innerCur.next;
                }
            }
        }
        return head;
    }





}
