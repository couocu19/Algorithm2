package linklist;

public class ReverseBetween {
    public static void main(String[] args) {

    }
}


class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode res = new ListNode(0);
        res.next = head;
        ListNode node = res;
        for(int i =1;i<m;i++){
            node = node.next;
        }

        //找到待反转的第一个结点的前一个结点
        ListNode nextHead = node.next;
        ListNode pre = null;
        ListNode next = null;

        //局部反转
        for(int i =m;i<=n;i++){
            next = nextHead.next;
            nextHead.next = pre;
            pre = nextHead;
            nextHead = next;
        }


        //将反转的第一个节点与反转之后的结点相连接
        node.next.next = next;
        //将反转的第一个节点的前一个结点与反转的最后一个结点相连接
        node.next = pre;

        return head;

    }
}