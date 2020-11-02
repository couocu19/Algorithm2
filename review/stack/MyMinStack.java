package review.stack;

import java.util.Stack;

public class MyMinStack {
    public static void main(String[] args) {


    }
}

class MinStackss {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStackss() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        } else {
            int min = minStack.peek();
            if (x <= min) {
                minStack.push(x);
            }

        }
    }

    public void pop() {
        if(stack.empty())
            return;
        int x = stack.pop();
        if(!minStack.empty()){
            int y = minStack.peek();
            if(x == y)
                minStack.pop();
        }

    }

    public int top() {

        if(stack.empty())
            return -1;
        int t = stack.peek();

        return t;
    }

    public int getMin() {
        if(minStack.empty()){
            return -1;
        }

        int min = minStack.peek();
        return min;
    }
}
