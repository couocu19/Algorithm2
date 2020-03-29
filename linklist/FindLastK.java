package linklist;


//寻找链表的倒数第k个元素
public class FindLastK {
    public static void main(String[] args) {


    }

    public static ListNode find(ListNode head,int k){
        int i;
        ListNode fast = head.next;
        ListNode slow = head.next;
        for(i =0;i<k&&fast!=null;i++){
            fast = fast.next;
        }
        //判断是否已经超过链表的长度
        //如果超过长度直接返回最后一个结点
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
