package top100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No20 {
    public static void main(String[] args) {
        String str = ")";
        Solution20 s = new Solution20();
        System.out.println(s.isValid(str));
    }
}


class Solution20 {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('<','>');
        map.put('{','}');
        map.put('[',']');
        int len = s.length();
        Stack stack = new Stack();
        for(int i = 0;i<len;i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '<' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{
                if(stack.empty())
                    return false;
                Character c = (Character) stack.pop();
                if(s.charAt(i) != map.get(c))
                    return false;
            }
        }
//        if(!stack.empty())
//            return false;
//        return true;

        return stack.empty();

    }

    public boolean isValid1(String s){
        if(s == null || s.length() == 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else if((stack.isEmpty()) || (c != stack.pop()))
                return false;
        }
        return stack.isEmpty();

    }
}
