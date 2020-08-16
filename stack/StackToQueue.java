package stack;

import java.util.Queue;
import java.util.Stack;

public class StackToQueue {
    public static void main(String[] args) {

        MyQueued myQueued = new MyQueued();

        myQueued.offer(1);
        myQueued.offer(2);
        myQueued.offer(3);

        System.out.println(myQueued.poll());

    }



}

/**
 * 功能：通过两个栈实现一个队列的功能
 *
 * 思路：
 *    一个栈用来保存入队的元素，被称为“入栈”；
 *    一个栈用来保存出栈的元素，被称为“出栈”；
 *
 *    入栈时，“入栈”push即可；
 *    出栈时，首先判断“出栈”是否为空，
 *    如果为空，就将“入栈”中的元素依次pop到“出栈”中，再返回出栈的首元素
 *    如果不为空，就直接返回“出栈"的首元素。
 *
 */
class MyQueued{

    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    public void offer(Integer data){
        inStack.push(data);

    }

    public Integer poll(){

        if(outStack.empty()){
            while(!inStack.empty()){
                int elem = inStack.pop();
                outStack.push(elem);
            }
            return outStack.pop();
        }else{
            return outStack.pop();

        }

    }

}