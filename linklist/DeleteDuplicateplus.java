package linklist;

public class DeleteDuplicateplus {
    public static void main(String[] args) {
        ListNode list = new ListNode(3, null);
        //ListNode list1 = new ListNode(2,list);
        ListNode list3 = new ListNode(3, list);
        ListNode list5 = new ListNode(2, list3);
        ListNode list4 = new ListNode(2, list5);
        ListNode list2 = new ListNode(1, list4);
        Solutionp s = new Solutionp();
        ListNode l1 = s.deleteDuplicates(list2);
        while (l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;

        }
    }

    //设置一个快指针和慢指针
    //这个思路也太好了
   static class Solutionp {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null)
                return head;
            ListNode pre = new ListNode(-1000);
            pre.next = head; //与原链表进行拼接
            ListNode slow = pre;
            ListNode fast = pre.next;
            while(fast != null){
                while(fast.next !=null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                    if(slow.next == fast){
                        slow = slow.next;
                    }else{
                        slow.next = fast.next;
                    }
                    fast = fast.next;
                }
            return pre.next;
            }
        }
    }



