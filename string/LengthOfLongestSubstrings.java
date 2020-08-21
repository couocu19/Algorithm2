package string;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstrings {
    public static void main(String[] args) {

        String s = "abc";
        Solution3s s1 = new Solution3s();

        System.out.println(s1.lengthOfLongestSubstring(s));
        

    }


}


class Solution3s {
    public int lengthOfLongestSubstring(String s) {
        if(s == null)
            return 0;

        int len = s.length();
        int i = 0;
        int j = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while (i<len && j<len){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                res = Math.max(res,(j-i));
            }else{
                res = Math.max(res,(j-i));

                set.remove(s.charAt(i));
                i++;
            }


        }
        return res;
    }




}