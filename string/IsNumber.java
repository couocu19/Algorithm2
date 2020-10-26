package string;

public class IsNumber {
    public static void main(String[] args) {

        String s = "12.-34e567";
        Solution20ss s1 = new Solution20ss();

        System.out.println(s1.isNumber(s));


    }


}

class Solution20s{
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0)
            return false;

        s = s.trim();
        try {
            double a = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }

        char c = s.charAt(s.length()-1);

        return (c >= '0' && c <= '9')||c == '.';

    }
}

class Solution20ss{
    //扫描字符串时的索引
    int i = 0;
    //表示数值的字符串遵循模式 A[.[B]][e|E[C]] ,其中，A，B，C分别代表整数部分，小数部分和指数部分和小数部分，其中整数部分的长度可以为0
    public boolean isNumber(String s) {
        if ( s == null || s.length() == 0)
            return false;
        //去掉首尾的空字符
        s = s.trim();
        boolean A = scanInteger(s), B = false, C = false;
        System.out.println(A);

        // 判断是否有B
        if (i < s.length() && s.charAt(i) == '.') {
            i++;
            B = scanUnsignedInteger(s);
            System.out.println(B);
        }
        //判断是否有C
        if(i < s.length() && (s.charAt(i) =='e' || s.charAt(i) == 'E')){
            i++;
            C = scanInteger(s);
            if(!C)
                return false;
        }

        return i == s.length() && (A||B);


    }

    private boolean scanInteger(String s){
        if(i<s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            i++;
        return scanUnsignedInteger(s);
    }

    private boolean scanUnsignedInteger(String s){
        int start = i;
        while (i<s.length()&& s.charAt(i)>='0' && s.charAt(i)<='9'){
            i++;
        }
        return i>start;
    }




}

class Solution20sss{
    int i = 0;
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0)
            return false;
        s = s.trim();
        boolean A = scanInteger(s),B = false,C = false;

        if(i<s.length() && s.charAt(i) == '.'){
            i++;
            B = scanUnsignedInteger(s);
        }

        if(i<s.length() && (s.charAt(i) == 'e'||s.charAt(i) == 'E')){
            i++;
            C = scanInteger(s);

            if(!C)
              return false;
        }

        return i == s.length() &&(A||B);

    }

    private boolean scanInteger(String s){
        if(i<s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-'))
            i++;
        return scanUnsignedInteger(s);
    }


    private boolean scanUnsignedInteger(String s){

        int start = i;
        while (i<s.length() && (s.charAt(i) >='0' && s.charAt(i)<='9')){
            i++;
        }
        return i>start;
    }




}


