package stack;

public class MyQueueNode {

    public static void main(String[] args) {
        QueueNode1<Integer> queueNode = new QueueNode1<>();
        queueNode.enQueue(1);
        System.out.println(queueNode.size());
        queueNode.deQueue();
    }
}

//用没有头结点的链表实现一个队列
class QueueNode<T>{

    Node<T> pFront;
    Node<T> pBack;

    public QueueNode() {
       pBack = pFront = null;
    }


    public int size(){
        int size = 0;
        Node<T> temp = pFront;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    public boolean isEmpty(){
        if(pFront == null)
            return true;
        else
            return false;
    }

    //入队
    public void enQueue(T e){
        Node<T> p = new Node<>();
        p.data = e;
        p.next = null;
        if(pFront == null){
            pFront = pBack = p;
        }else{
            pBack.next = p;
            pBack = p;
        }
    }


    //出队
    public void deQueue(){
        if(pFront == null)
            return;
        pFront = pFront.next;
        if(pFront == null ){
            System.out.println("出队成功，队列已经为空~");
            pBack = null;
        }

    }


    //获取队首元素
    T getFront(){
        if(pFront == null){

            System.out.println("获取队列元素失败，队列已经为空~");
            return null;
        }
        return pFront.data;
    }

    //获取队尾元素
    T getBack(){
        if(pBack == null){
            System.out.println("获取队尾元素失败，队列已经为空~");
            return null;
        }

        return pBack.data;


    }


}


class QueueNode1<T>{
    Node<T> pHead;
    Node<T> pEnd;

    public QueueNode1(){
        pEnd = pHead = null;
    }

    public boolean isEmpty(){
        if(pHead == null)
            return true;

        return false;
    }

    public int size(){
        Node<T> temp = pHead;
        int size = 0;
        while(temp!=null){
            temp = temp.next;
            size++;
        }

        return size;
    }

    public void enQueue(T e){
        Node<T> p = new Node<>();
        p.data = e;
        p.next = null;
        if(pHead == null){
            pHead = pEnd = p;
        }else{
            //尾插法插入
            pEnd.next = p;
            pEnd = p;
        }
    }

    public void deQueue(){
        if(pHead == null)
            return;
        pHead = pHead.next;
        if(pHead == null) {
            pEnd = null;
            System.out.println("出队成功，该队列已经为空");
        }
    }

    public T getFront(){
        if(pHead == null)
            return null;

        return pHead.data;

    }

    public T getBack(){
        if(pEnd == null)
            return null;

        return pEnd.data;


    }



}




class Node<T>{
    T data;
    Node<T> next;
}

