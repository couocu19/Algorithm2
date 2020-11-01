package string;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {

        String str = "()(())";
        Solution32 s = new Solution32();
        System.out.println(s.longestValidParentheses(str));




    }
}

class Solution32 {


    //需要找出最长有效括号的字符串长度，而不是最有效括号的个数
    public int longestValidParentheses(String s) {
        int len = s.length();
        Stack<Character>  stack = new Stack<>();
        stack.push('#');

        int count = 0;
        for(int i =0;i<len;i++){
            if(s.charAt(i) == ')') {
               // System.out.println(i);
                int c = stack.peek();
                if (c == '(') {
                    stack.pop();
                    count++;
                  //  System.out.println(count + " " + i);
                }
            }else {
                stack.push(s.charAt(i));
            }
        }

        return count*2;


    }
}