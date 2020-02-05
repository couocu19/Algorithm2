package linklist;

public class DetectCycle {

    public static void main(String[] args) {
        Solution142 s = new Solution142();
        //ListNode list1 = new ListNode(2,list);

        ListNode list4 = new ListNode(1);

        ListNode list3 = new ListNode(2,list4);
        //ListNode list5 = new ListNode(0, list3);
        //list4 = new ListNode(2, list4);
        list4 = new ListNode(1, list3);


//        int pos = s.getIndex(list2,)
        System.out.println(s.detectCycle(list4));
    }


}


//只能通过四个例子
 class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode p = head;
        ListNode q = null;
        int pos = -1;
        int data = 0;
        while(p!=null && p.next!=null){
            q = p.next;
            pos = getIndex(head,q.val);
            System.out.println(pos);
            if(pos<data){
                //System.out.println(pos);
                return q;
            }
            data++;
        }

        return null;

    }

    public int getIndex(ListNode head,int val){
        ListNode p = head;
        int locate = 0;
        while(p.next!=null && p.next!=null){
            if(p.val == val){
                return locate;
            }
            p = p.next;
            locate++;

        }
        return -1;

    }
}
