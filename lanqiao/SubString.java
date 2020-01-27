package lanqiao;

import java.util.HashSet;
import java.util.Set;

//求某个字符串的不重复子串有多少个
public class SubString {
    public static void main(String[] args) {
        String s = "0100110001010001";
        System.out.println(subString(s));

    }


    //方法：暴力枚举+HashSet存储，利用set中的元素不可重复的特点
    public static int subString(String s){
        Set<String> set = new HashSet<>();
        int sum = 0;
        int len = s.length();
        for(int i =0;i<len;i++){
            for(int j = 0;j<len-i;j++){
                String s1 = s.substring(j,j+i+1);
                //System.out.println(s1);
                set.add(s1);
            }
        }
        sum = set.size();
        return sum;

    }
}
