package stack;

import java.util.Stack;

//用O(1)的时间复杂度获取栈中的最小元素
public class GetMinStack {
    public static void main(String[] args) {

        MyStacks stacks = new MyStacks();

        stacks.push(3);
        stacks.push(-1);
        stacks.push(5);
        stacks.push(8);

        System.out.println(stacks.getMin());



    }
}


/**
 * 定义一个类，可以实现获取栈中的最小元素，并且时间复杂度为O(1)
 * 思路：
 *    通过空间换取时间的思路，内部中使用两个栈，一个用来保存入栈的元素，
 *    一个栈的顶部用于保存栈中的最小元素。
 * 时间复杂度：O(1)
 * 空间复杂度：O(n)
 *
 */
class MyStacks{
    private Stack<Integer> elemStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();


    public void push(Integer data){
        elemStack.push(data);

        if(minStack.empty()){
            minStack.push(data);
        }else if(data<minStack.peek()){
            minStack.push(data);
        }
    }

    public void pop(){

        int top = elemStack.pop();

        if(top == minStack.peek()){
            minStack.pop();
        }
    }

    public Integer getMin(){
        if(minStack.empty()){
            return Integer.MAX_VALUE;
        }

        return minStack.peek();

    }
}
