package review.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {



    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int i = 0;
        int j =0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while (i<len && j<len){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                res = Math.max(res,j-i);
            }else{

                set.remove(s.charAt(i));

                i++;

            }

        }
        return res;

    }
}