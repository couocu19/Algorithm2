package top100;

import java.util.HashSet;
import java.util.Set;

public class No3 {
    public static void main(String[] args) {
        String str = "aaaaaaaaaaaaa";
        Solution3 s = new Solution3();
        System.out.println(s.lengthOfLongestSubstring(str));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null)
            return 0;
        int len = s.length();
        int i;
        int j;
        i = j = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(i<len && j<len){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                res = Math.max(res,(j-i));
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}