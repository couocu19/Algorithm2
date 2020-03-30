package linklist;

public class ReSort {
    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        Construct.printList(head);
        head = resortMerge(head);
        Construct.printList(head);
    }

    //交替重新排序链表
    //1-2-3-4-5-6-7-8
    //1-8-2-7-3-6-4-5
    public static ListNode resortMerge(ListNode head){
        if(head == null || head.next == null||head.next.next == null){
            return null;
        }
        ListNode mid = findMid(head);
        ListNode reverseMid = resorts(mid);
        ListNode cur1 = head.next;
        ListNode cur2 = reverseMid;
        ListNode temp = null;
        while(cur1.next!=null){
            temp = cur1.next;
            cur1.next = cur2;
            cur1 = temp;

            temp = cur2.next;
            cur2.next = cur1;
            cur2 = temp;
        }
        cur1.next = cur2;

        return head;

    }

    //快慢指针
    public static ListNode findMid(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPre = head;
        //判断条件
        while(fast!=null&&fast.next!=null){
            slowPre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //把链表断开成两个独立的子链表
        slowPre.next = null;
        return slow;
    }

    //将不带头结点的链表逆序
    public static ListNode resorts(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head.next;
        ListNode pre = head;
        //关键！首先要将第一个节点之后的数据置空
        pre.next = null;
        ListNode next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }




}
