package string;

import java.util.regex.Pattern;

public class MyAtoi {
    public static void main(String[] args) {

        Solution8 s =  new Solution8();
        //System.out.println(Integer.valueOf("-000012"));
        //System.out.println(Integer.MIN_VALUE);
        //System.out.println(s.isInteger(" "));
        System.out.println(s.myAtoi("+11e530408314"));

    }
}

class Solution8 {
    public int myAtoi(String str) {

        int len = str.length();
        if(str.equals(""))
            return 0;
        //处理前几个字符是空格的情况
        while(str.charAt(0) == ' '){
            str = str.substring(1,len);
            len--;
            if(len == 0)
                break;
        }
        //处理特殊情况
        if(str.equals("-") || str.equals("+")||str.equals(""))
            return 0;
        //如果该字符串是数字型的，则可以在溢出范围内直接转换
        if(isInteger(str)){
            try {
                Integer n = Integer.valueOf(str);
                return Integer.valueOf(str);
            } catch (NumberFormatException e) {
                if(str.charAt(0) == '-'){
                    return Integer.MIN_VALUE;
                }else{
                    return Integer.MAX_VALUE;
                }
            }
        }

        if((str.charAt(0) < 48 || str.charAt(0) > 57)){
            if(str.charAt(0)!='-' && str.charAt(0)!='+'){
                return 0;
            }else{
                if(str.charAt(1) < 48 || str.charAt(1) > 57) {
                    return 0;
                }
            }
        }
        for(int i =1;i<len;i++){
            if(str.charAt(i)< 48 || str.charAt(i)>57) {
                str = str.substring(0, i);
                if(isInteger(str)){
                    try {
                        Integer n = Integer.valueOf(str);
                        return Integer.valueOf(str);
                    } catch (NumberFormatException e) {
                        if(str.charAt(0) == '-'){
                            return Integer.MIN_VALUE;
                        }else{
                            return Integer.MAX_VALUE;
                        }
                    }
                }
            }

        }
        return Integer.valueOf(str);
    }

    public boolean isInteger(String str) {
        int len = str.length();
        if(str.charAt(0) <48 || str.charAt(0)>57){
            if(str.charAt(0) == '-' || str.charAt(0) == '+'){
                for(int i =1;i<len;i++){
                    if(str.charAt(i) <48 || str.charAt(i)>57){
                        return false;
                    }
                }
            }else{
                return false;
            }
        }else{
            for(int i =1;i<len;i++){
                if(str.charAt(i) <48 || str.charAt(i)>57){
                    return false;
                }
            }
        }
        return true;

    }
}
