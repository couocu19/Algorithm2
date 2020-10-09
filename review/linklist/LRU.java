package review.linklist;

import java.util.HashMap;
import java.util.Map;

public class LRU {
    public static void main(String[] args) {
        MyLRU ml = new MyLRU(3);
        ml.put(1,2);
        ml.put(3,4);
        ml.put(5,99);

        ml.put(5,7);

        System.out.println(ml.get(1));

        System.out.println( ml.get(5));;




    }
}


class MyLRU{

    class DLinklist{
        int key;
        int value;
        DLinklist pre;
        DLinklist next;
        public DLinklist(int key, int value) {
            this.key = key;
            this.value = value;
        }
        public DLinklist(){

        }
    }

    Map<Integer,DLinklist> map;
    int size;
    int maxSize;

    DLinklist first;
    DLinklist last;
    public MyLRU(int max){
        map = new HashMap<>();
        maxSize = max;
        size = 0;
        first = new DLinklist();
        last  = new DLinklist();
        first.next = last;
        last.pre = first;
    }

    public void put(int key,int value){
        DLinklist node = map.get(key);
        if(node == null){
            size++;
            node = new DLinklist(key,value);
            map.put(key,node);
            addToHead(node);
            if(size>maxSize){
                size--;
                int tail = removeTail();
                map.remove(tail);
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }


    public int get(int key){
        DLinklist val = map.get(key);
        if(val == null)
            return -1;

        moveToHead(val);
        return val.value;

    }



    private void moveToHead(DLinklist node){
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinklist node){
        node.next = first.next;
        first.next.pre = node;
        node.pre = first;
        first.next = node;
    }

    private int removeTail(){
        DLinklist tail = last.pre;
        removeNode(tail);

        return tail.value;
    }

    private void removeNode(DLinklist node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }





}