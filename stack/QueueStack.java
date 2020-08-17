package stack;

import java.util.Stack;

public class QueueStack {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());


    }




}


class CQueue {

    private Stack<Integer> inStack ;
    private Stack<Integer> outStack ;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();

    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {

        if(outStack.empty()){
            if(inStack.empty()){
                return -1;
            }

                while (!inStack.empty()) {
                    int top = inStack.pop();
                    outStack.push(top);
                }
                return outStack.pop();
        }else{

            return outStack.pop();
        }

    }
}