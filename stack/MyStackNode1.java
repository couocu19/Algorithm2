package stack;

public class MyStackNode1 {
    public static void main(String[] args) {

        MyStack1<Integer> stack1 = new MyStack1<>();
        stack1.push(1);

        System.out.println("栈顶元素为："+stack1.peek());

        System.out.println("栈大小为："+stack1.size());
        stack1.pop();
        System.out.println("弹栈成功~");
        stack1.pop();


    }

}


class MyStack1<T>{

    Node1<T> node1;

    public MyStack1(){
        node1 = new Node1<T>();
        node1.data = null;
        node1.next = null;
    }

    int size(){
        Node1<T> temp;
        int size  = 0;
        for(temp = node1.next;temp!=null;temp = temp.next){
            size++;
        }
        return size;
    }

    boolean isEmpty(){
        if(node1 == null || node1.next  == null)
            return true;
        return false;
    }


    //用头插法实现
    void push(T e){
        Node1<T> node = new Node1<>();
        node.data = e;
        node.next = node1.next;
        node1.next = node;
    }



    T peek(){
        Node1<T> temp = node1.next;
        if(temp!=null) {
            return temp.data;
        }
        System.out.println("栈已为空！");
        return null;
    }

    T pop(){
        Node1<T> temp = node1.next;
        if(temp!=null){
            node1.next = temp.next;
            return temp.data;
        }

        System.out.println("栈已为空！");
        return null;

    }





}

class Node1<T>{
    T data;
    Node1<T> next;

}
