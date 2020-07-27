package stack;

public class MyStackNode {
    public static void main(String[] args) {
        MyNodeStack<Integer> myNodeStack = new MyNodeStack<>();
        myNodeStack.push(1);
        System.out.println(myNodeStack.size());
        System.out.println(myNodeStack.pop());
        myNodeStack.pop();


    }
}


//利用链表实现一个栈
class MyNodeStack<T>{
    private LNode<T> arrNode;
    private int stackSize;

    public MyNodeStack() {
        arrNode = new LNode<>();
        arrNode.data = null;
        arrNode.next = null;
        stackSize = 0;

    }

    boolean isEmpty(){
        return stackSize == 0;
    }

    int size(){
        return stackSize;
    }

    T top(){
        if(isEmpty()){
            return null;
        }else{
            return arrNode.next.getData();
        }
    }

    T pop(){
        if(stackSize>0){
            stackSize--;
            LNode<T> temp = arrNode.next;
            arrNode.next = temp.next;
            return temp.getData();
        }else{
            System.out.println("栈已为空！");
            return null;
        }
    }

    void push(T item){
        LNode<T> node = new LNode<>();
        node.data = item;
        LNode<T> curNode = arrNode.next;
        arrNode.next = node;
        node.next = curNode;
        stackSize++;
    }










}

//定义链表结点
class LNode<T>{
    T data;
    LNode<T> next;

    public T getData() {
        return data;
    }

    public LNode<T> getNext() {
        return next;
    }

    //    public LNode(T data, LNode<T> next) {
//        this.data = data;
//        this.next = next;
//    }


}