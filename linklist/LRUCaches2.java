package linklist;

import java.util.HashMap;
import java.util.Map;

public class LRUCaches2 {
    public static void main(String[] args) {
        LRUCaches3 l = new LRUCaches3(5);

        l.put(1,3);
        l.put(2,7);
        l.put(8,30);
        l.put(6,9);
        l.put(4,7);

        l.get(8);

        l.put(9,44);
        System.out.println(l.get(1));
        System.out.println(l.get(8));


    }

}

class LRUCaches3 {

    Map<Integer,DListNode> map;
    int size = 0;
    int maxSize;

   class DListNode{
        int key;
        int value;
       public DListNode(int key, int value) {
           this.key = key;
           this.value = value;
       }

       public DListNode(){


       }
       DListNode pre;
       DListNode next;
   }

   DListNode head;
   DListNode last;

   public LRUCaches3(int maxSize){
       map = new HashMap<>();
       this.maxSize = maxSize;
       head = new DListNode();
       last = new DListNode();
       head.next = last;
       last.pre = head;
   }
   public void put(int key,int value){
       DListNode node = map.get(key);
       if(node == null){
           node = new DListNode(key,value);
           map.put(key,node);
           addToHead(node);
           size++;
           if(size>maxSize){
               size--;
               int r = removeTail();
               map.remove(r);
           }
       }else {
           node.value = value;
           moveToHead(node);
       }

   }

   public int get(int key){
       DListNode node = map.get(key);
       if(node == null){
           System.out.println("ok");
           return -1;
       }
       moveToHead(node);
       return node.value;
   }

   private void moveToHead(DListNode node){
       removeNode(node);
       addToHead(node);
   }


   private void removeNode(DListNode node){
       node.pre.next = node.next;
       node.next.pre = node.pre;
   }


   private int removeTail(){
       DListNode tail = last.pre;
       removeNode(tail);
       return tail.key;
   }


   private void addToHead(DListNode node){
       head.next.pre = node;
       node.next = head.next;
       head.next = node;
       node.pre = head;
//
//       node.pre = head;
//       node.next = head.next;
//       head.next.pre = node;
//       head.next = node;
   }



}


