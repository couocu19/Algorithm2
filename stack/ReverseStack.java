package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        Stack<Integer> stack1 = reverse(stack);

//        int i = 0;
//        while(!stack1.empty()){
//            System.out.println(stack1.get(i));
//
//        }
        for(int j =0;j<stack1.size();j++){

            System.out.print(stack1.get(j)+" ");
        }



    }

    public static Stack<Integer> reverse(Stack<Integer> stack){

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> result = new Stack<>();
        while(!stack.empty()){
            result.add(stack.pop());
        }
        return result;

    }





}


