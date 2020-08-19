package stack;

import java.util.Stack;

public class MinAddToMakeValid {

    public static void main(String[] args) {

        String str = "))";
        Solution921 s = new Solution921();
        System.out.println(s.minAddToMakeValid3(str));



    }

}

class Solution921 {
    public int minAddToMakeValid(String S) {

        int len = S.length();

        Stack<Character> stack = new Stack<>();

        for(Character c:S.toCharArray()){
            if(stack.isEmpty()){
                stack.push(c);
            }else{

                if(c == ')' && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
        }

        return stack.size();

    }


    public int minAddToMakeValid1(String S) {
        if(S.equals(""))
            return 0;

        int len = S.length();

        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));

       for(int i =1;i<len;i++){
            if(stack.isEmpty()){
                stack.push(S.charAt(i));
            }else{

                if(S.charAt(i) == ')' && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(S.charAt(i));
                }
            }
        }

        return stack.size();

    }

    public int minAddToMakeValid2(String S) {
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }

    public int minAddToMakeValid3(String S) {
        int left = 0;
        int right = 0;
        for(Character c:S.toCharArray()){
            left += (c == '('?1:-1) ;

            if(left == -1){
                right++;
                left++;
            }

        }

        return left+right;




    }


}
