package linklist;

public class ReverseNext {
    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        Construct.printList(head);
        reverse(head);
        Construct.printList(head);


    }

    //只适用于有偶数个结点的情况
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return null;
        }

        if(head.next.next == null){
            return head;
        }

        ListNode oddNode = head.next;
        ListNode evenNode = head.next.next;
        ListNode oddNext = null;
        ListNode evenNext = null;
        ListNode oddPre = head;

        while(evenNode.next!=null){
            oddNext = oddNode.next.next;
            evenNext = evenNode.next.next;

            oddPre.next = evenNode;
            evenNode.next = oddNode;
                oddNode.next = oddNext;
                oddNode.next = null;
            oddPre = oddNode;
                oddNode = oddNext;
                evenNode = evenNext;

        }
        //处理最后的结点
//        oddPre.next = evenNode;
//        evenNode.next = oddNode;
//        oddNode.next = null;


        return head;

    }


}
