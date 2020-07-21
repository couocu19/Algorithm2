package string;

import javax.crypto.spec.ChaCha20ParameterSpec;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "   ";
        Solution3 s1 = new Solution3();
        System.out.println(s1.lengthOfLongestSubstring1(s));


    }

}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
            return 0;
        if(s.trim().isEmpty() || s.length() == 1)
            return 1;
        int i = 0;
        int j = 0;
        int len = s.length();
        int maxL = Integer.MIN_VALUE;
        List<Character> list = new ArrayList<>();
        while(j<len){
            if(!list.contains(s.charAt(j))){
                list.add(s.charAt(j));
                j++;
            }else {
                list.remove(0);
                i++;
            }
            maxL = Math.max((j-i),maxL);
        }
        return maxL;

    }

    public int lengthOfLongestSubstring1(String s){
        if(s.equals(""))
            return 0;
        if(s.trim().isEmpty() || s.length() == 1)
            return 1;
        int i = 0;
        int j = 0;
        int len = s.length();
        int maxL = Integer.MIN_VALUE;


        while(j<len && i<len){
            String flag = s.substring(i,j+1);
            if((j+1)<len&&!flag.contains(s.substring(j+1,j+2))){
                j++;
            }else{
                i++;
            }

            maxL = Math.max((j-i),maxL);

        }

        return maxL+1;


    }


}