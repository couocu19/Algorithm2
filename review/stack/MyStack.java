package review.stack;

import java.util.Stack;

public class MyStack {

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(0);
        m.push(1);
        m.push(0);
        System.out.println(m.min());
        m.pop();
        //System.out.println(m.pop());
        System.out.println(m.min());


    }
}


class MinStack {

    /** initialize your data structure here. */

    Stack<Integer> stack;
    Stack<Integer> minStack;


    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.empty()){
            minStack.push(x);
        }else{
            int min = minStack.peek();
            if(x<=min){
                minStack.push(x);
            }
        }

    }

    public void pop() {

        int p = stack.pop();
        int p1 = minStack.peek();
        if(p == p1)
            minStack.pop();


    }

    public int top() {

        int t = stack.peek();
        return t;
    }

    public int min() {

        int m = minStack.peek();
        return m;
    }
}
