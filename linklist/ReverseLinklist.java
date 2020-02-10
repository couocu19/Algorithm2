package linklist;

import java.util.List;

public class ReverseLinklist {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode cur = head;
        ListNode temp = null;

        for(int i = 1;i <=6;i++){
            temp = new ListNode(i);
            cur.next = temp;
            cur = temp;
        }

        //默认头结点中的数据为0
        for(ListNode p = head;p!=null;p = p.next){
            System.out.print(p.val+"->");
        }
        System.out.println();
        reverseList(head);

        for(ListNode p = head;p!=null;p = p.next){
            System.out.print(p.val+"->");
        }

    }


    //链表的就地逆置
    //需要设置三个指针变量
    static ListNode reverseList(ListNode head){

        if(head == null || head.next == null || head.next.next == null)
            return head;

        ListNode pre = null; //当前节点的前驱结点
        ListNode cur = null; //循环遍历到的当前结点
        ListNode next = null; //当前结点的下一个结点

        //初始化
        cur = head.next;
        //下面几行被注释掉的代码可有可无
//        next = cur.next;
//        cur.next = null;
//
//        pre = cur;
//        cur = next;

        //使当前遍历到的结点cur指向其的前驱结点
        while(cur.next!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur.next;
            cur = next;
        }

        //结点最后一个结点指向倒数第二个结点
        cur.next = pre;
        //链表的表头指向原来的尾结点
        head.next = cur;

        return head;
    }
}


