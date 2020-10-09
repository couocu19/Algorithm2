package linklist;

import java.util.HashSet;
import java.util.Set;

//借助辅助空间删除链表中的重复项
//空间换时间
public class RemoveDupSet {
    public static void main(String[] args) {
        int i = 1;
        ListNode head = new ListNode();
        head.next = null;
        ListNode temp = null;
        ListNode cur = head;
        for(;i<7;i++){
            temp = new ListNode();
            if(i%2 == 0){
                temp.val = i+1;
            }else if(i%3 == 0){
                temp.val = i-2;
            }else{
                temp.val = i;
            }
            temp.next = null;
            cur.next = temp;
            cur = temp;
        }
        System.out.println("删除重复结点前:");
        for(cur = head.next;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();
        remove(head);
        System.out.println("删除重复结点后:");
        for(cur = head.next;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }



    }

    public static ListNode remove(ListNode head){
        Set<Integer> set = new HashSet<>();
        ListNode cur = head.next;
        ListNode curNext = null;
        for(;cur!=null&&cur.next!=null;){
            curNext = cur.next;
            if(set.contains(cur.val)){
                cur.next = curNext.next;
                cur = cur.next;
            }else{
                cur = cur.next;
            }
            set.add(cur.val);
        }

        return head;
    }



}
