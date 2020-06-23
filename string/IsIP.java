package string;


/**
 * 合法的ip地址格式满足：
 *   （1~255）.(0~255).(0~255).(0~255)
 * 解题思路：
 *   1.首先从字符串的长度上判断，字符串的长度必须限制在7~15之间
 *   2.一个合法的ip地址一定可以通过“.“分割为四部分，如果不能，即如果分割之后不是四部分，则一定是不合法的地址。
 *   3.如果满足分条件二，那么每一部分一定可以转换为一个整数，如果不能，那么一定不合法。
 *   4.如果条件1 2 3均满足，那么每一部分的数字满足其范围，则为合法的ip地址。
 *
 */
public class IsIP {

    public static void main(String[] args) {
        String a = "1.1.1.aaa";
        String b = "10.1.1111.2";
        String c = "0.0.0";
        String d = "255.255.255.255";
        String f = "c.c.c.c";
        String g = "f,gkkkkkkkkkk";
        String h = "125.6.7.233";
        System.out.println(isValid(a));
        System.out.println(isValid(b));
        System.out.println(isValid(c));
        System.out.println(isValid(d));
        System.out.println(isValid(g));
        System.out.println(isValid(g));
        System.out.println(isValid(g));

    }


    public static boolean isValid(String s){
        int len = s.length();
        if(len<7 || len>15)
            return false;

        String[] nIp = s.split("\\.");
        System.out.println(nIp.length);
        if(nIp.length<4)
            return false;

        Integer n1 = null;
        Integer n2 = null;
        Integer n3 = null;
        Integer n4 = null;
        try {
            n1 = Integer.parseInt(nIp[0]);
            n2 = Integer.parseInt(nIp[1]);
            n3 = Integer.parseInt(nIp[2]);
            n4 = Integer.parseInt(nIp[3]);
        } catch (NumberFormatException e) {
            return false;
        }


        if(n1<1 || n1>255
           || n2<0 || n2>255
           || n3<0 || n3>255
           || n4<0 || n4>255) {
            return false;
        }

        return true;

    }

    public static boolean isNumeric(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57) return false;
         }
         return true;
    }

}
