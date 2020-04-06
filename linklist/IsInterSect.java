package linklist;


import java.util.HashSet;
import java.util.Set;

//判断两个链表是否交叉
public class IsInterSect {
    public static void main(String[] args) {
        int i = 1;
        //链表1头结点
        ListNode head1 = new ListNode();
        head1.next = null;

        //链表2头结点
        ListNode head2 = new ListNode();
        head2.next = null;

        ListNode tmp = null;
        ListNode cur = head1;
        ListNode p = null;
        for(;i<8;i++){
            tmp = new ListNode(i);
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
            if(i == 5){
                p = tmp;
            }
        }

        //构造第二个链表
        cur = head2;
        for(i = 1;i<5;i++){
            tmp = new ListNode(i);
            tmp.next = null;
            cur.next = tmp;
            cur = tmp;
        }
        //使他们相交于结点5
        cur.next = p;
        Construct.printList(head1);
        Construct.printList(head2);
        ListNode insertNode = isInterSect(head1,head2);
        if(insertNode == null){
            System.out.println("两个链表不相交");
        }else{
            System.out.println("两个链表相交于:");
            System.out.println(insertNode.val);

        }


    }


    ///方法一:申请辅助空间法
    public static ListNode isInterSect(ListNode h1,ListNode h2){
        if(h1 == null || h1.next == null || h2 == null
                || h2.next == null ||h1 == h2){
            return null;
        }

        Set<ListNode> set = new HashSet<>();
        ListNode cur = h1.next;
        while(cur!=null){
            //System.out.println("1");
            set.add(cur);
            cur = cur.next;
        }
        cur = h2.next;
        while(cur!=null){
            if(set.contains(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;

    }

    //相接法
    public static ListNode isInterSect1(ListNode h1,ListNode h2) {
        if(h1 == null || h1.next == null || h2 == null
                || h2.next == null ||h1 == h2){
            return null;
        }

        ListNode last1 = Construct.findLast(h1);
        ListNode cur2 = h2.next;
        //首先将两个链表连接起来
        last1.next = cur2;
        //判断连接后的链表是否成环
        ListNode meet = isLoop(h1);
        //如果链表不成环，说明原来的两个链表没有交叉结点
        if(h1 == null){
            return null;
        }else{
            //如果成环,那么成环的入口结点就是交叉结点
            ListNode intersect = findLoopNode(h1,meet);
            return intersect;

        }

    }

    //尾结点法
    /**
     * 解题方法:1.首先将两个链表各遍历一遍,记录出两个链表的长度l1和l2；
     *         2.如果两个链表交叉，交叉后的结点必定是相同的；
     *         3.先从较长链表出发|l2-l1|个结点,之后两个链表同步前进,
     *           直到遇到相同结点为止。
     * @param h1
     * @param h2
     * @return
     */
    public static ListNode isInterSect2(ListNode h1,ListNode h2){
        if(h1 == null || h1.next == null || h2 == null
                || h2.next == null ||h1 == h2){
            return null;
        }

        int l1 = getLength(h1);
        int l2 = getLength(h2);
        int differ = Math.abs(l1-l2);
        ListNode cur1 = h1.next;
        ListNode cur2 = h2.next;
        if(l1>l2){
            for(int i =0;i<differ;i++){
                cur1 = cur1.next;
            }
        }else{
            for(int i =0;i<differ;i++){
                cur2 = cur2.next;
            }
        }
        while(cur1!=null){
            cur1 = cur1.next;
            cur2 = cur2.next;
            if(cur1 == cur2){
                return cur1;
            }

        }
        return null;
    }


     private static int getLength(ListNode head){
        ListNode cur = head.next;
        int len = 0;
        while(cur!=null&&cur.next!=null){
            len++;
            cur = cur.next;
        }

        return len;

     }

    private static ListNode isLoop(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head.next;
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return slow;
            }

        }
        return null;

    }

    private static ListNode findLoopNode(ListNode head,ListNode meetNode){
        ListNode cur = head.next;
        ListNode cur1 = meetNode;
        while(cur!=cur1){
            cur = cur.next;
            cur1 = cur1.next;
        }

        return cur;
    }
}
