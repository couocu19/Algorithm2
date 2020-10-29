package review.linklist;

import java.awt.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {
    public static void main(String[] args) {



    }

}


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> pq = new PriorityQueue<>((v1,v2)->v1.val-v2.val);

        for(ListNode node:lists){
            if(node!=null) {
                pq.offer(node);
            }
        }

        ListNode res = new ListNode(0);
        ListNode temp = res;

        while (!pq.isEmpty()){
            ListNode minNode = pq.poll();
            temp.next = minNode;
            temp = minNode;
            if(minNode.next!=null){
                pq.offer(minNode.next);

            }
        }
        return res.next;

    }



    public ListNode merge(ListNode[] lists){
        Queue<ListNode> queue = new PriorityQueue<>((v1,v2)->(v1.val-v2.val));
        for(ListNode node:lists){
            if(node!=null) {
                queue.offer(node);
            }
        }
        ListNode resHead = new ListNode(0);
        ListNode temp = resHead;

        while ((!queue.isEmpty())){
            ListNode min = queue.poll();
            temp.next = min;
            temp = min;
            if(min.next!=null){
                queue.offer(min.next);
            }
        }
        return resHead.next;
    }

    //使用优先队列
    public ListNode merge1(ListNode[] lists){
        Queue<ListNode> queue = new PriorityQueue<>((v1,v2)->(v1.val-v2.val));
        for(ListNode l:lists){
            queue.offer(l);
        }
        ListNode resHead = new ListNode(0);
        ListNode tmp = resHead;
        ListNode min;
        while (!queue.isEmpty()){
            min = queue.poll();
            tmp.next = min;
            tmp = min;
            if(min.next!=null){
                queue.offer(min.next);
            }
        }
        return resHead.next;

    }


    //10.29

    public ListNode merge2(ListNode[] lists){
        Queue<ListNode> queue = new PriorityQueue<>((v1,v2)->(v1.val-v2.val));
        for(ListNode l:lists){
            queue.offer(l);
        }

        ListNode res = new ListNode(0);
        ListNode tmp = res;

        while (!queue.isEmpty()){
            ListNode minNode = queue.poll();
            tmp.next = minNode;
            tmp = minNode;
            if(minNode.next!=null){
                queue.offer(minNode);
            }
        }

        return res.next;




    }
}