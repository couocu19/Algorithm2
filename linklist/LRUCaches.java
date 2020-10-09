package linklist;

import java.util.HashMap;
import java.util.Map;

public class LRUCaches {

    public static void main(String[] args) {

        int key = 5;
        LRUCache l = new LRUCache(5);
//        int param_1 = obj.get(key);
//        System.out.println(param_1);
//        obj.put(1,2);l
//        obj.put(2,6);
//        obj.put(3,8);
//        obj.put(5,99);
//        param_1 = obj.get(5);
//        System.out.println(param_1);

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


class LRUCache {
    private int capacity;
    private Map<Integer,DLinkedNode> map = new HashMap<>();
    private DLinkedNode head,tail;
    private int size;

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode(){

        }
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

        //指定LRU缓存的最大值
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DLinkedNode node = map.get(key);
        if(node == null){
            return -1;
        }
        //如果key存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode(key,value);
            map.put(key,newNode);
            addToHead(newNode);
            ++size;
            if(size>capacity){
                DLinkedNode tail = removeTail();
                //删除哈希表中对应的项
                map.remove(tail.key);
                --size;
            }
        }else{
            //如果存在该key值，就先替换数据值，然后置于表
            node.value = value;
            moveToHead(node);

        }

    }

    //双向链表插入节点到链表头
    private void addToHead(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    //双向链表删除某个节点
    private void removeNode(DLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

    }

    //将存在的某个节点移到链表头
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    public DLinkedNode removeTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}









//自己实现一个双向链表
//class DLinkedNode{
//    int key;
//    int value;
//    DLinkedNode prev;
//    DLinkedNode next;
//
//    //定义头结点和尾结点
//    private DLinkedNode head,tail;
//
//    public DLinkedNode(){
//
//    }
//    public DLinkedNode(int key, int value) {
//        this.key = key;
//        this.value = value;
//    }
//
//    //双向链表插入节点到链表头
//    public void addToHead(DLinkedNode node){
//        node.prev = head;
//        node.next = head.next;
//        head.next.prev = node;
//        head.next = node;
//    }
//
//    //双向链表删除某个节点
//    public void removeNode(DLinkedNode node){
//        node.prev.next = node.next;
//        node.next.prev = node.prev;
//
//    }
//
//    //将存在的某个节点移到链表头
//    public void moveToHead(DLinkedNode node){
//        removeNode(node);
//        addToHead(node);
//    }
//
//    public DLinkedNode removeTail(){
//        DLinkedNode res = tail.prev;
//        removeNode(res);
//        return res;
//
//    }
//
//
//}