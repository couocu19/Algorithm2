package midleetcode;

import java.lang.String;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//超出时间限制
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        Scanner w = new Scanner(System.in);
        Solution3 aaa = new Solution3();
        String ss = w.next();
        System.out.println(aaa.lengthOfLongestSubstring(ss));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        for(int i=0;i<s.length();i++){

            for(int j=i+1;j<=s.length();j++) {
                  if(all(s,i,j))
                      max = Math.max(max,j-i);
                }
            }
        return max;
        }

    public boolean all(String s,int start,int end){
        Set<Character> set = new HashSet<>();

        for(int i = start;i < end;i++){
            Character ch = s.charAt(i);
            if(set.contains(ch))
                return false;
            set.add(ch);
        }
        return true;

    }
}
