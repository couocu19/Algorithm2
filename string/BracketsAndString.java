package string;

import javax.xml.stream.events.Characters;
import java.util.Collections;
import java.util.Stack;

public class BracketsAndString {
    public static void main(String[] args) {
        String s = "3(cd1(ab))";
        System.out.println(toS(s));


    }

    public static String toS(String s){
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        int t = 0;
        int f[] = new int[len];
        for(int i =0;i<len;i++){
                if(Character.isDigit(s.charAt(i)) == true){
                    int n = Integer.parseInt(s.charAt(i)+"");
                    stack2.push(n);
                }
            if(s.charAt(i) == '('){
                stack1.push(s.charAt(i));
                 f[t++] = i+1;
            }
            if(s.charAt(i) == ')'){
                stack1.pop();
                Integer num = (Integer) stack2.pop();
                String sFlag = s.substring(f[t-1],i);
                String str = String.join("",Collections.nCopies(num,sFlag));
                sb.replace(f[t-1]-2,i+1,str);
                len = len- (i+1-f[t-1]+2) + str.length();
                i = i + (str.length() - (i+1-f[t-1]+2));
                s = sb.toString();
                t--;
            }

        }
        return sb.toString();

    }
}



