package linklist;

//删除排序链表中的重复元素
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode list = new ListNode(3,null);
        //ListNode list1 = new ListNode(2,list);
       ListNode list3 = new ListNode(3,list);
        ListNode list5 = new ListNode(2,list3);
        ListNode list4 = new ListNode(1,list5);
       ListNode list2 = new ListNode(1,list4);
        Solutionl s = new Solutionl();
        ListNode l1 = s.deleteDuplicates(list2);
        while(l1!=null){
            System.out.println(l1.val);
            l1 = l1.next;

        }



    }
}

class Solutionl {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }else if(head.next == null){
            return head;
        }else{
            ListNode preNode = head;
            while(preNode.next!= null && preNode != null) {
                ListNode p = preNode.next;
                if (p.val == preNode.val) {
                    preNode.next = p.next;
                }else{
                    preNode = preNode.next;
                }
            }
        }
        return head;
    }
}
