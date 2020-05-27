package linklist;

import java.util.HashMap;
import java.util.Map;

public class LRUCaches1 {
    public static void main(String[] args) {


    }
}

class LRUCache1{
    int maxSize;
    int size;
    Map<Integer,DLinkNode> map = new HashMap<>();
    DLinkNode head,tail;
    public LRUCache1(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }


    class DLinkNode{
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
        public DLinkNode(){

        }
        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public int get(int key){
        DLinkNode node = map.get(key);
        if(node==null){
            return -1;
        }else{
            moveToHead(node);
            return node.value;
        }


    }

    public void put(int key,int value){
        DLinkNode node = map.get(key);
        if(node == null){
            node = new DLinkNode(key,value);
            addToHead(node);
            ++size;
            if(size>maxSize){
              DLinkNode tail = removeTail();
              map.remove(tail.key);
                --size;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }

    }


    private void addToHead(DLinkNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkNode node){
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode removeTail(){
        DLinkNode res = tail.prev;
        removeNode(res);
        return res;
    }






}
