package linklist;


//链表中可以用到快慢指针可以解决的问题
public class FastAndSlow {
    //找到链表的中间结点
    //默认链表带有头结点
    public static ListNode findMidNode(ListNode head) {
        if(head == null || head.next ==null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPre = head;
        while(fast!=null && fast.next!=null){
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //将原链表断开
        slowPre.next = null;
        return slow;
    }


    //找到链表的倒数第k个结点
    //快慢指针法
    public static ListNode findLastK(ListNode head,int k){
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head.next;
        int i =0;
        for(i = 0;i<k&&fast!=null;i++){
            fast = fast.next;
        }
        //判断是否超过了原链表长度
        if(i<k){
            return fast;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }

    //判断链表是否有环
    //如果链表成环则返回快慢指针相遇结点如果不成环则返回空
    public static ListNode isLoop(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast  = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return slow;
            }
        }
        return null;
    }

    //找到带环结点
    public static ListNode loopNode(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode meetNode = isLoop(head);
        if(meetNode == null){
            return null;
        }
        ListNode cur = head.next;
        while(cur!=meetNode){
            cur = cur.next;
            meetNode = meetNode.next;
        }

        return cur;
    }
}
