package string;

import java.util.Collections;
import java.util.Stack;

public class BracketsAndString {
    public static void main(String[] args) {
        String s = "6h3k";
        System.out.println(toS(s));

    }

    public static String toS(String s){
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        int t = 0;
        int f[] = new int[len];
        int di = 0;
        Integer num;
        String sFlag;
        String str;
        String str1;
        int lenN;
        for(int i =0;i<len;i++){
                if(Character.isDigit(sb.charAt(i)) == true){
                    di = i;
                    while(Character.isDigit(sb.charAt(i)) == true){
                        i++;
                    }
                    int n = Integer.parseInt(sb.substring(di,i));
                    if(sb.charAt(i) == '(') {
                        stack2.push(n);
                    }else{
                        str1 = String.join("",Collections.nCopies(n,sb.charAt(i)+""));
                        sb.replace(di,i+1,str1);
                        len = sb.length();
                        i = i + (str1.length()-(i+2-di));
                        System.out.println(sb.toString());
                        System.out.println(i);
                    }
                }

            if(sb.charAt(i) == '('){
                stack1.push(sb.charAt(i));
                f[t++] = i+1;
            }
            if(sb.charAt(i) == ')'){
                stack1.pop();
                num = (Integer) stack2.pop();
                sFlag = sb.substring(f[t-1],i);
                str = String.join("",Collections.nCopies(num,sFlag));
                lenN = String.valueOf(num).length();
                sb.replace(f[t-1]-1-lenN,i+1,str);
               //每次修改完字符串都需要修改长度原字符串以及下标i
                len = sb.length();
                i = i + (str.length() - (i+1-f[t-1]+2));
                t--;
            }
        }
        return sb.toString();

    }

}



