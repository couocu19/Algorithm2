package stack;

//用链表实现一个简单的LRU缓存方案
public class LRUNode {
    public static void main(String[] args) {



    }
}

class LRU{
    ListNode front;
    ListNode rear;
    int maxSize;

    public LRU(int maxSize){
        this.maxSize = maxSize;
        front = null;
        rear = null;
    }



    public void put(int data){
        ListNode node = new ListNode(data);
        if(front == null){
            front = node;
            rear = front;
        }else if(size()<maxSize){
            rear.next = node;
            rear = node;
        }else{   //大小达到了缓存最大的容量
            rear.next = node;
            front = front.next; //淘汰最初加入到缓存的元素
        }
    }

    public int get(int key){

        if(front == null)
            return -1;

        if(front.next == null){
            return front.val == key?key:-1;
        }
        ListNode temp = front;
        ListNode prev = null;

        while(temp!=null && temp.val!=key){
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;

        temp.next = front;
        front = temp;
        return temp.val;



    }

    public int size(){
        int size = 0;
        ListNode temp = front;
        while(temp!=null){

            temp = temp.next;
            size++;
        }
        return size;

    }







}



class ListNode{
    Integer val;
    ListNode next;
    public ListNode(Integer val) {
        this.val = val;
    }
}
