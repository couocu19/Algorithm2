package agorithmUtils;

import java.util.regex.Pattern;

public class FindNum {

    //判断某个整数num中是否存在数字a
    public static boolean isExist(int num,int a){
        String str = String.valueOf(num);
        String str1 = String.valueOf(a);
        if(str.contains(str1)){
            return true;
        }else{
            return false;
        }

    }

    //判断某个字符串是否为数字型
    //正则表达式判断
    public boolean isInteger(String str) {

        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
