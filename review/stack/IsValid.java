package review.stack;

import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {


    }
}

class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            if(c == '(')
                stack.push(')');
            if(c == '{')
                stack.push('}');
            if(c == '[')
                stack.push(']');
            else if(stack.isEmpty() || c!=stack.pop())
                return false;

        }
        return stack.isEmpty();
    }
}
