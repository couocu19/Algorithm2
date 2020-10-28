package review.linklist;

public class MergeTwoLists {
    public static void main(String[] args) {

        ListNode h1 = Construct.sortConstructor();
        ListNode h2 = Construct.sortConstructor2();

        Solution25 s = new Solution25();
        Construct.printList(s.mergeTwoLists(h1,h2));


    }
}

class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l2 == null)
            return l1;
        if(l1 == null)
            return l2;
        else if(l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }

    }


    public ListNode merge(ListNode l1,ListNode l2){
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        else if(l1.val<=l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        }else{
            l2.next = merge(l1,l2.next);
            return l2;
        }

    }
}