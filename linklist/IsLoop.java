package linklist;


import java.util.HashSet;
import java.util.Set;

//判断一个较大的链表是否带环
public class IsLoop {
    public static void main(String[] args) {
        ListNode head = Construct.loopListConstructor();
        ListNode head1 = Construct.sortConstructor();
        System.out.println(loopNode(head).val);
        System.out.println(setLoop(head).val);


    }

    //申请辅助空间判断
    public static ListNode setLoop(ListNode head){
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head.next;
        while(cur!=null){
            if(set.contains(cur)){
                return cur;
            }
            set.add(cur);
            cur = cur.next;
        }

        return null;
    }

    //快慢指针法判断该链表是否成环
    public static ListNode fastAndSlowLoop(ListNode head){
        ListNode slow = head.next;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }

    /**
     * 方法:设置两个指针，一个从链表头出发，一个从两指针相遇点出发，
     * 二者必定会在链表成环的入口相遇
     * @param head
     * @return
     */
    public static ListNode loopNode(ListNode head){

        ListNode cur = head.next;
        ListNode meetNode = fastAndSlowLoop(head);
        if(meetNode == null){
            return null;
        }

        while(cur!=meetNode){
            cur  =cur.next;
            meetNode = meetNode.next;
        }

        return cur;

    }



}
