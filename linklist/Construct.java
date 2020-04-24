package linklist;

import java.util.Random;

public class Construct {

    //构造链表的数据为排序不重复连续的数据
    public static ListNode sortConstructor(){
        ListNode head = new ListNode();
        head.next = null;
        ListNode temp = null;
        ListNode cur = head;
        for(int i =1;i<=2;i++){
            temp = new ListNode(i);
            temp.next = null;
            cur.next = temp;
            cur = temp;
        }

        return head;
    }

    //构造链表的数据为排序相邻重复的数据
    public static ListNode duplicateSortConstructor(){
        ListNode head = new ListNode();
        head.next = null;
        ListNode temp = null;
        ListNode cur = head;
        for(int i =1;i<=8;i++){
            temp = new ListNode();
            if(i%2 == 0){
                temp.val = i-1;
            }else{
                temp.val = i;
            }
            temp.next = null;
            cur.next = temp;
            cur = temp;
        }

        return head;
    }

    //构造链表的数据为不排序但有重复数据
    public static ListNode duplicateConstructor(){
        ListNode head = new ListNode();
        head.next = null;
        ListNode temp = null;
        ListNode cur = head;
        for(int i =1;i<=8;i++){
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
        return head;
    }

    //构造链表的数据为含有随机数据
    public static ListNode randomConstructor(){
        ListNode head = new ListNode();
        head.next = null;
        ListNode temp = null;
        ListNode cur = head;
        Random random = new Random();
        int ran ;
        for(int i =1;i<=10;i++){

            ran = random.nextInt(10)+1;
            temp = new ListNode(ran);
            temp.next = null;
            cur.next = temp;
            cur = temp;

        }
        return head;

    }

    //构造一个带环的链表
    public static ListNode loopListConstructor(){
        ListNode head = new ListNode();
        ListNode temp = null;
        head.next = null;
        ListNode cur = head;
        for(int i =1;i<=4;i++){
            temp = new ListNode(i);
            temp.next = null;
            cur.next = temp;
            cur = temp;
        }
        ListNode flag = new ListNode(5);
        cur.next = flag;
        cur = flag;
        for(int i = 6;i<=9;i++){
            temp = new ListNode(i);
            temp.next = null;
            cur.next = temp;
            cur = temp;
        }
        cur.next = flag;

        return head;

    }


    //输出链表内容
    public static void printList(ListNode head){
        ListNode cur = null;
        for(cur = head.next;cur!=null;cur = cur.next){
            System.out.print(cur.val+" ");
        }
        System.out.println();
    }

    //找到链表的最后一个结点
    public static ListNode findLast(ListNode head){
        ListNode cur = head.next;
        while(cur!=null&&cur.next!=null){
            cur = cur.next;
        }

        return cur;
    }



}
