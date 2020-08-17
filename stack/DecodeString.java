package stack;

import java.util.LinkedList;
import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {

        Solution394ss s = new Solution394ss();
        String str = "3[a2[c]]";
        System.out.println(s.decodeString(str));
    }


}

class Solution394 {
    private StringBuilder sb ;

    public String decodeString(String s) {
        sb = new StringBuilder("");
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        for(int i =0;i<len;){
            if(s.charAt(i)<48 || s.charAt(i)>57){
                sb.append(s.charAt(i));
                i++;
            }else{
                while(s.charAt(i++)!=']') {
                    stack.push(s.charAt(i));

                }

                while(stack.peek()<48 || stack.peek()>57){



                }




            }



        }
        return null;
    }

    private void setString(String s){





    }
}

class Solution394s {
    public String decodeString(String s) {

        StringBuilder res = new StringBuilder();

        int multi = 0;

        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();

        for(Character c:s.toCharArray()){
            if(c == '['){
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();

            }else if(c == ']'){

                StringBuilder tmp = new StringBuilder();
                int curMulti = stack_multi.removeLast();

                for(int i =0;i<curMulti;i++){
                    tmp.append(res);
                }

                res = new StringBuilder(stack_res.removeLast()+tmp);

            }

            else if(c >= '0' && c <='9'){
                multi = multi * 10 +Integer.parseInt(c+"");
               // System.out.println(multi);
            }else{
                res.append(c);
            }
        }
        return res.toString();

    }



}

class Solution394ss{
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> ch = new Stack<>();
        int num = 0;
        StringBuilder res = new StringBuilder("");

        for(Character c:s.toCharArray()){
            if(c == '['){
                nums.push(num);
                ch.push(res.toString());
                //还原
                res = new StringBuilder();
                num = 0;
            }else if(c == ']'){
                StringBuilder tmp = new StringBuilder();
                int size = nums.pop();
                for(int i =0;i<size;i++){
                    tmp.append(res);
                }
                String lastRes = ch.pop();
                res = new StringBuilder(lastRes + tmp);

            }else if(c>'0' &&c<='9'){
                num = num*10 + Integer.parseInt(c.toString());
            }else{
                res.append(c);
            }

        }

        return res.toString();


    }





}
