package string;

import java.util.regex.Pattern;

public class MyAtoi {
    public static void main(String[] args) {

        Solution8 s =  new Solution8();
      //  System.out.println(Integer.valueOf("  -1234"));


        System.out.println(Integer.MIN_VALUE);
        System.out.println(s.myAtoi("-91283472332"));
//        System.out.println( s.isInteger("  -1234"));



    }
}

class Solution8 {
    public int myAtoi(String str) {
        int len = str.length();
        int flag = 0;
        while(str.charAt(0) == ' '){
            str = str.substring(1,len);
            len--;
        }
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

           // return Integer.valueOf(str);
        }



        for(int i =0;i<len;i++){
            if(str.charAt(0)=='-') {
                if (str.charAt(0) < 48 || str.charAt(0) > 57) {
                    return 0;
                }
                if(str.charAt(i)< 48 || str.charAt(i)>57) {
                    str = str.substring(0, i);
                    return Integer.valueOf(str);

                }
            }
            else{
                if(str.charAt(1) < 48 || str.charAt(1) > 57){
                    return 0;
                }else{
                    if(str.charAt(i)< 48 || str.charAt(i)>57) {
                      str = str.substring(0, i);
                      return Integer.valueOf(str);

                }
                }
            }

            //System.out.println(str);
        }

        return Integer.valueOf(str);

    }

    public boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }






}
