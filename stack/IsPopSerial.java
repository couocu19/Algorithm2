package stack;

import java.util.Stack;

public class IsPopSerial {
    public static void main(String[] args) {
        String push = "12345";
        String pop = "53412";
        IsPopSerial ip = new IsPopSerial();

        System.out.println(ip.isTrue(push,pop));

    }

    //根据入栈序列判断一个序列是不是有效的出栈序列
    public boolean isTrue(String push,String pop){
        int pushIndex = 0;
        int popIndex = 0;
        int pushLen = push.length();
        int popLen = pop.length();
        Stack<Character> s = new Stack<>();

        if(popLen!=pushLen)
            return false;

        while(pushIndex<pushLen){
            s.push(push.charAt(pushIndex));
         //   System.out.println(s.peek()+" "+pop.charAt(popIndex));
            while ( !s.empty()&& s.peek() == pop.charAt(popIndex)){
               // System.out.println(s.peek());
                s.pop();
                popIndex++;
            }

            pushIndex++;

        }

        System.out.println(s.empty());
        System.out.println(popIndex);
        System.out.println(pushIndex);
        if(s.empty() && pushIndex == popIndex) {
            return true;
        }


            return false;






    }


}
