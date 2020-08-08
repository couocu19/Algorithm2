package stack;

import java.util.ArrayList;
import java.util.Queue;

public class MyQueue {
    public static void main(String[] args) {

        queue<Integer> qs = new queue<>();
        qs.enQueue(1);
        qs.enQueue(2);
        System.out.println(qs.getFront());

        qs.deQueue();

        System.out.println(qs.getFront());
        System.out.println(qs.size);
        System.out.println(qs.getBack());



    }

}

//使用数组实现一个队列
class queue<T>{
    ArrayList<T> array;
    int size;

    public queue(){
        array = new ArrayList<>();
        size = 0;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){

        return size == 0;
    }

    T getFront(){
        return array.get(0);

    }

    T getBack(){
        return array.get(array.size()-1);

    }

    void deQueue(){
        if(size!=0){
            array.remove(0);
            size--;
        }else {
            System.out.println("该队列已经为空！");

        }
    }

    void enQueue(T e){
        array.add(e);
        size++;
    }







}

//这种方法最大的缺点就是不能充分利用数组的前半部分空间
//解决方法：当数组的最后一个元素被占满之后，可以循环利用数组前半部分空出的元素空间
class Queue1<T>{
    private ArrayList<T> arr = new ArrayList<>();
    int front; //标记队列首元素
    int rear;  //标记队列尾元素

    public Queue1(){
        front = 0;
        rear = 0;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public int size(){
        return rear-front;
    }

    public T getFront(){
        if(isEmpty()){
            return null;
        }
        return arr.get(front);
    }

    public T getBack(){
        if(isEmpty()){
            return null;
        }

        return arr.get(rear-1);
    }

    public void deQueue(){
        if(rear>front){
            front++;
        }

        else{
            System.out.println("队列已经为空~");
        }
    }

    public void enQueue(T e){
        arr.add(e);
        rear++;
    }

}
