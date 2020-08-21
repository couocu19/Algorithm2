package stack;

public class CircularDeque {

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(4);// 设置容量大小为3
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());// 返回 true
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getFront());

        //System.out.println(circularDeque.isEmpty());

        System.out.println(circularDeque.deleteFront());
        System.out.println(circularDeque.insertFront(6));			        // 返回 true
        System.out.println(circularDeque.insertLast(5)); 		        // 返回 true
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertFront(6));
         // 返回 true
        //System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
        //System.out.println(circularDeque.getRear()) ;
       // System.out.println(circularDeque.insertLast(7));
       // System.out.println(circularDeque.insertFront(7));			        // 返回 true

      //  System.out.println(circularDeque.isFull());				        // 返回 true
      //  System.out.println(circularDeque.deleteLast());		        // 返回 true
       // System.out.println(circularDeque.insertLast(4));			        // 返回 true
       // System.out.println(circularDeque.isEmpty());// 返回 4


    }


}


class MyCircularDeque {

    private int k;
    private LNode front;
    private LNode rear;

    public MyCircularDeque(int k) {
        this.k = k;
        front = null;
        rear = null;

    }

    public boolean insertFront(int value) {
        LNode node = new LNode(value);
        if(front == null){
            front = node;
            rear = front;
            return true;
        }else if(isFull()){
            return false;
        } else{

            node.next = front;
            front = node;
            return true;
        }
    }

    public boolean insertLast(int value) {
        LNode node = new LNode(value);
        if(front == null){
            System.out.println("ok");
            front = node;
            rear = front;
            return true;
        }else if(isFull()){
            return false;
        } else{
            rear.next = node;
            rear = node;
            return true;
        }
    }


    public boolean deleteFront() {
        if(front == null){
            return false;
        }

        //注意特殊条件的设置
        if(front == rear){
            front = rear = null;
            return true;
        }

        front = front.next;
        return true;

    }


    public boolean deleteLast() {

        if(front == null)
            return false;

        //注意特殊条件的设置
        if(front == rear){
            front = rear = null;
            return true;
        }


        LNode temp = front;

        while(temp.next!=rear){
            temp = temp.next;
        }
        //删除尾结点
        rear = temp;
        rear.next = null;
        return true;

    }


    public int getFront() {
        if(front == null)
            return -1;
        return front.val;
    }


    public int getRear() {
        if(front == null)
            return -1;

        return rear.val;

    }


    public boolean isEmpty() {
        if(front == null)
            return true;

        return false;

    }


    public boolean isFull() {
        if(front == null)
            return false;
        int size = 0;
       LNode tmp = front;
       while(tmp!=null){
           tmp = tmp.next;
           size++;
       }

       if(size == k)
           return true;
       else
           return false;

    }



    class LNode{
        int val;
        LNode next;
        public LNode(int val){
            this.val = val;
        }

        public LNode(){

        }
    }

}
