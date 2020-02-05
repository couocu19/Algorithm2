package linklist;

public class DetectCycle1 {
    public static void main(String[] args) {

    }

}

//基本思路：快慢指针
//Floyd算法
 class Solution142s{
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        if(getIntersect(head) == null)
            return null;

        ListNode p = head;
        ListNode q = getIntersect(head);

        while(p!=q){
            p = p.next;
            q = q.next;
        }

        return p;




    }

    public ListNode getIntersect(ListNode head){

        ListNode p = head;
        ListNode fastp = head;

        while(fastp!=null && fastp.next!=null){
            p = p.next;
            fastp = fastp.next.next;
            if(p == fastp){
                return p;
            }

        }

        return null;

    }
}
