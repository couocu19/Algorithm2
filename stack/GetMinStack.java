package stack;

import java.util.Stack;

//用O(1)的时间复杂度获取栈中的最小元素
public class GetMinStack {
    public static void main(String[] args) {




    }
}


class MyStacks{
    private Stack<Integer> elemStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
}

public void push(int data){
    elemStack.push(data);
    //更新保存最小元素的栈
    if(elemStack.empty())
        minStack.push(data);





}