package linklist;


/**
 * 思路：如果给定的结点不是最后一个结点，可以通过把其后继结点的数据复制到当前节点中，
 * 然后通过删除后继结点的犯法来实现
 */
public class DeleteNodePlus {
    public static void main(String[] args) {
        ListNode head = Construct.sortConstructor();
        Construct.printList(head);
        ListNode cur = head.next;
        int k = 5;
        int i = 1;
        while(cur!=null){
            cur = cur.next;
            if(i == k-1){
                break;
            }
            i++;
        }
        System.out.println(cur.val);
        delete(cur);
        Construct.printList(head);
    }

    /**
     *
     * @param p 链表中待删除的链表指针
     * @return  如果指针p是链表的最后一个结点，那么该节点无法删除
     *          如果不是，那么删除这个结点并返回true
     */
    public static boolean delete(ListNode p){
        if(p == null || p.next == null){
            return false;
        }

        p.val = p.next.val;
        p.next = p.next.next;
        return true;
    }
}
