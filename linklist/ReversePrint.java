package linklist;

import review.tree.ConstructorTree;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePrint {
    public static void main(String[] args) {

        ListNode head = Construct.sortConstructor();
        Solution06 s = new Solution06();
        int[] res = s.reversePrint1(head.next);
        for(int a:res){
            System.out.print(a+" ");
        }
        System.out.println();

    }



}


class Solution06 {
    //方法一:先将链表反转，再遍历一遍加入到数组中
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();

        ListNode h1 = reverse(head);
        for(ListNode tmp = h1;tmp!=null;tmp = tmp.next){
            res.add(tmp.val);
        }
        int[] r = new int[res.size()];
        int i = 0;
        for(Integer a:res){
            r[i++] = a;
        }
        return r;
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode cur = head.next;
        ListNode pre = head;
        ListNode next = null;
        pre.next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }

    //方法二：根据题目的要求，我们需要使得链表中后访问的元素先打印，所以可以将结点中的数据加到栈中，再依次输出

    public int[] reversePrint1(ListNode head){
        Stack<Integer> stack = new Stack<>();
        //ListNode tmp = head;
        int len = 0;
        for(ListNode tmp = head;tmp!=null;tmp = tmp.next){
            stack.push(tmp.val);
            len++;
        }
        int[] res = new int[len];
        for(int i =0;i<len;i++){
            res[i] = stack.pop();
        }
        return res;
    }

}