package linklist;


//寻找链表的倒数第k个元素
public class FindLastK {
    public static void main(String[] args) {
        ListNode head = Construct.randomConstructor();
        int k = 3;
        ListNode flag =  find(head,k);
        Construct.printList(head);
        System.out.println(flag.val);
    }

    public static ListNode find(ListNode head,int k){
        int i;
        ListNode fast = head.next;
        ListNode slow = head.next;
        for(i=0;i<k&&fast!=null;i++){
            fast = fast.next;
        }
        //判断移动步数是否超过链表长度
        if(i<k){
            return fast;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
