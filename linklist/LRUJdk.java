package linklist;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUJdk {
    public static void main(String[] args) {

        LRUCache3<Integer,Integer> lru = new LRUCache3<>(3);

        lru.put(2,33);
        lru.put(3,44);
        lru.put(4,55);
        lru.put(5,66);




    }


}

//基于java-jdk中的linkedHaspMap实现的lru缓存策略
class LRUCache3<K, V> extends LinkedHashMap<K, V> {
    private final int CACHE_SIZE;
    // 这里就是传递进来最多能缓存多少数据
    public LRUCache3(int cacheSize) {
        // 这块就是设置一个hashmap的初始大小，同时最后一个true指的是让linkedhashmap按照访问顺序来进行排序，最近访问的放在头，最老访问的就在尾

        //在这个构造方法中,有个accessOrder,它不同的值有不同的意义:
        //false, 所有的Entry按照插入的顺序排列
        //true, 所有的Entry按照访问的顺序排列

        //访问的顺序:如果有1 2 3这3个Entry，那么访问了1，就把1移到尾部去，即2 3 1。
        // 每次访问都把访问的那个数据移到双向队列的尾部去，那么每次要淘汰数据的时候，双向队列最头的那个数据不就是最不常访问的那个数据了吗？
        // 换句话说，双向链表最头的那个数据就是要淘汰的数据。

        //Math.ceil()方法执行的是向上取整计算，返回大于等于函数参数并且与之最接近的整数
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        // 这个意思就是说当map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据
        return size() > CACHE_SIZE;
    }

}

class LRUCaches4<K,V> extends LinkedHashMap<K,V>{
    private int CACHE_SIZE;

    public LRUCaches4(int c){
        super(c,0.75f,true);
        CACHE_SIZE = c;
    }


    protected  boolean removeEldestEntry(Map.Entry eldest){
        return size()>CACHE_SIZE;
    }





}



class LruCaches<K,V> extends LinkedHashMap<K,V>{
    private int CACHE_SIZE;

    public LruCaches(int c){
        super(c,0.75f,true);
        c = CACHE_SIZE;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>CACHE_SIZE;
    }
}
