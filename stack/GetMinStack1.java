package stack;

import java.util.Stack;

public class GetMinStack1 {
    public static void main(String[] args) {


    }
}


class MyStack2{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(Integer a){
        stack.push(a);
        if(minStack.empty()){
            minStack.push(a);
        }else if(a<minStack.peek()){
            minStack.push(a);
        }
    }

    public Integer pop(){
        Integer p = stack.pop();
        if(p.equals(minStack.peek())){
            minStack.pop();
        }
        return p;
    }

    public Integer getMin(){
        if(minStack.empty()){
            return Integer.MAX_VALUE;
        }
        return minStack.peek();

    }




}
