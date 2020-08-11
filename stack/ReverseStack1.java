package stack;

import java.util.Stack;

public class ReverseStack1 {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        for(int i =0;i<stack.size();i++){
            System.out.println(stack.get(i));
        }

        ReverseStack1 rv = new ReverseStack1();
        rv.reverse(stack);
        for(int i =0;i<stack.size();i++){
            System.out.println(stack.get(i));
        }


    }



    //将栈底元素移动到栈顶
    //需要递归进行
    private void moveToTop(Stack<Integer> stack){
        if(stack.empty())
            return;
        int top1 = stack.pop();
        if(!stack.empty()){
            moveToTop(stack);
            int top2 = stack.pop();
            stack.push(top1);
            stack.push(top2);
        }else{
            stack.push(top1);
        }

    }


    //递归翻转栈中的元素，需要调用上一个方法
    public void reverse(Stack<Integer> stack){
        if(stack.empty())
            return;

        moveToTop(stack);
        int top = stack.pop();
        reverse(stack);
        stack.push(top);
    }
}
