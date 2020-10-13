package review.stack;

import java.util.Stack;

//两个栈实现一个队列
public class CQueue {
    public static void main(String[] args) {



    }
}


class MyQueue{
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();


    public void appendTail(Integer num){
        inStack.push(num);
    }

    public void deletedHead(Integer num){

        if(outStack.empty()){
            while (!inStack.empty()){
                Integer elem = inStack.pop();
                outStack.push(elem);
            }
             outStack.pop();
        }else{
            outStack.pop();
        }


    }





}



