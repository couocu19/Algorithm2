package top100;

import java.util.List;

public class No21 {
    public static void main(String[] args) {



    }

    public ListNode create1(){
        ListNode head1 = new ListNode();
        ListNode tmp = head1;
        tmp.next = new ListNode(1);
        tmp = tmp.next;
        tmp.next = new ListNode(3);
        tmp = tmp.next;
        tmp.next = null;
        return head1;
    }
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        res.next = null;
        ListNode tmp = res;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                tmp.next = new ListNode(list1.val);
                list1 = list1.next;
            }else{
                tmp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
        }
        if(list1 != null)
            tmp.next = list1;
        if(list2 != null)
            tmp.next = list2;
        return res;
    }
}



class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
