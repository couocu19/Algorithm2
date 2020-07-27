package stack;

import java.util.ArrayList;

public class MyStack {
    public static void main(String[] args) {

        MyFirstStack<Integer> stack = new MyFirstStack<Integer>();
        stack.push(1);
        stack.push(2);
        System.out.println("栈顶元素为："+stack.top());

        System.out.println("栈的大小为："+stack.size());

        stack.pop();

        System.out.println("弹栈成功~");
        stack.pop();
        stack.pop();



    }

}

//利用数组自己实现一个栈
class MyFirstStack<T>{
    private ArrayList<T> arr;
    private int stackSize;

    public MyFirstStack() {
        stackSize = 0;
        arr = new ArrayList<T>();
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
        }
        return arr.get(stackSize-1);
    }
    //弹栈
    T pop(){
        if(stackSize>0){
            return arr.get(--stackSize);
        }else{
            System.out.println("栈已为空！");
            return null;
        }
    }
    void push(T item){
        arr.add(item);
        stackSize++;
    }
}

//练习……

class MyFirstStack1<T>{
    private ArrayList<T> arr;
    private int stackSize;
    public MyFirstStack1(ArrayList<T> arr, int stackSize) {
      arr = new ArrayList<>();
      stackSize = 0;
    }

    boolean isEmpty(){
        return stackSize == 0;
    }

    int size(){
        return stackSize;
    }

    T peek(){
        if(isEmpty()){
            return null;
        }
            return arr.get(stackSize-1);
    }

    T pop(){
        if(stackSize == 0){
            System.out.println("栈已为空！");
            return null;
        }else{
            return arr.get(--stackSize);

        }
    }
    void push(T item){
        arr.add(item);
        stackSize++;
    }


}