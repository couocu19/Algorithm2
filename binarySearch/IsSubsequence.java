package binarySearch;

import java.util.HashMap;
import java.util.Map;

public class IsSubsequence {

    public static void main(String[] args) {
        String s1 = "aaaaaa";
        String s2 = "bbaaaa";
        Solution392 s = new Solution392();
        System.out.println(s.isSubsequence2(s1,s2));


    }

}


class Solution392 {

    //这个方法有漏洞。。
    //如果原字符串汇总有重复的就不行
    public boolean isSubsequence(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int len = t.length();
        for(int i =0;i<len;i++){
            map.put(t.charAt(i),i);
        }
        for(int i =0;i<s.length();i++){
            System.out.println(s.charAt(i));
            if(!map.containsKey(s.charAt(i))){
                System.out.println("1");
                return false;
            }
            if(i>0 && map.get(s.charAt(i))<map.get(s.charAt(i-1)))
                return false;
        }

        return true;
    }

    //妙啊……
    //对于s中每一个字符都优先匹配最开始遇到的
    //如果当前s对应的ch和t字符串遍历到的字符不匹配，则i++
    public boolean isSubsequence1(String s,String t){

        int len = t.length();
        int i = 0;
        for(Character ch:s.toCharArray()){
            while (i<len && t.charAt(i)!=ch)
                i++;
            i++;
        }
        return i<=len;

    }

    //利用库中的indexOf(ch,index)方法
    public boolean isSubsequence2(String s,String t){
        int j = -1;
        char[] chars = s.toCharArray();
        for(int i =0;i<chars.length;i++){
            j = t.indexOf(chars[i],j+1);
            if(j == -1)
                return false;
        }

        return true;


    }
}