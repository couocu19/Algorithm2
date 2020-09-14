package linklist;

import java.lang.reflect.Array;
import java.util.*;

public class MergeKLists {

    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(4);
        ListNode h3 = new ListNode(5);
        h1.next = h2;
        h2.next = h3;
        h3.next = null;

        ListNode h4 = new ListNode(1);
        ListNode h5 = new ListNode(3);
        ListNode h6 = new ListNode(4);
        h4.next = h5;
        h5.next = h6;
        h6.next = null;

        ListNode h7 = new ListNode(2);
        ListNode h8 = new ListNode(6);
        h7.next = h8;
        h8.next = null;

        ListNode[] listNodes = {h1,h4,h7};
      //  System.out.println(listNodes[1].val);

        Solution23 s = new Solution23();

        ListNode[] l1 = {null};
        ListNode res = s.mergeKLists3s(listNodes);

        for(ListNode temp = res;temp!=null;temp = temp.next){
            System.out.print(temp.val+" ");
        }
        System.out.println();

    }


}

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0 || lists[0] == null)
            return null;
        ListNode head = new ListNode(0);
        head.next = null;
        int len = lists.length;
        ListNode temp = null;
        Integer[] nums = new Integer[10000];
        List<Integer> list = new ArrayList<>();
        int count = 0;

        for(int i =0;i<len;i++){
            temp = lists[i];
            while(temp!=null){
                list.add(temp.val);
                count++;
                temp = temp.next;
            }
        }
        nums = list.toArray(new Integer[0]);
        Arrays.sort(nums);
        ListNode res = head;
        for(int i =0;i<nums.length;i++){
            head.next = new ListNode(nums[i]);
            head = head.next;
        }
        return res.next;
    }
    public ListNode mergeKLists1(ListNode[] lists){
        int k = lists.length;
        ListNode resHead = new ListNode(0);
        ListNode tail = resHead;
        while (true){
            ListNode minNode = null;
            int minPointer = -1;
            for(int i =0;i<k;i++){
                if(lists[i] == null){
                    continue;
                }
                if(minNode == null || lists[i].val<minNode.val){
                    minNode = lists[i];
                    minPointer = i;
                }
            }

            if(minPointer == -1)
                break;

            tail.next = minNode;
            tail = tail.next;

            lists[minPointer] = lists[minPointer].next;

        }

        return resHead.next;
    }

    public ListNode mergeKLists2(ListNode[] lists){
        int k = lists.length;
        ListNode resHead = new ListNode(0);
        ListNode tail = resHead;
        while (true){
            ListNode minNode = null;
            int minPointer = -1;

            for(int i =0;i<k;i++){
                if(lists[i] == null)
                    continue;

                if(minNode == null || lists[i].val<minNode.val){
                    minNode = lists[i];
                    minPointer = i;
                }
            }

            if(minPointer == -1)
                break;
            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;
        }

        return resHead.next;

    }


    public ListNode mergeKLists3(ListNode[] lists){
        //定义比较器：使用小顶堆来构建优先队列
        Queue<ListNode> pq = new PriorityQueue<>((v1,v2)->v1.val-v2.val);
        for(ListNode node:lists){
            if(node!=null){
                pq.offer(node);
            }
        }
        ListNode resHead = new ListNode(0);
        ListNode tail = resHead;

        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;
            if(minNode.next!=null){
                pq.add(minNode.next);

            }
        }

        tail.next = null;

        return resHead.next;

    }


    //使用优先队列进行合并
    public ListNode mergeKLists3s(ListNode[] lists){
        //自定义比较器为小顶堆
        Queue<ListNode> pq = new PriorityQueue<>((v1,v2)->v1.val-v2.val);
        for(ListNode node:lists){
            pq.offer(node);
        }

        ListNode resHead = new ListNode(0);
        ListNode tail = resHead;

        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;

            if(minNode.next!=null){
                pq.offer(minNode.next);
            }
        }

        return resHead.next;







    }







}