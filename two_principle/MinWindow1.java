package two_principle;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinWindow1 {
    public static void main(String[] args) {
        String s = "ABAACBAB";
        String t = "ABC";
        Solution76s so = new Solution76s();
        System.out.println(so.minWindow(s,t));



    }



}

class Solution76s {
    //只能满足当t中的字符串是没有重复的情况，如果T中的字符串包含重复字符如"aa",则需要维护两个map来判断
    public String minWindow(String s, String t) {
        int len = s.length();
        Set<Character> set = new HashSet<>();
        Map<Character,Integer> map = new HashMap<>();
        for(Character c:t.toCharArray()){
            set.add(c);
        }
        int l = 0,r = -1;
        int resLen = Integer.MAX_VALUE;
        int resL = -1,reR = -1;
        int flag = 1;
        while(r<len){
            ++r;
            if(r<len && set.contains(s.charAt(r))){
                map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            }
            while(isContainsAll(map,set) && l<=r) {
                    if ((r - l + 1) < resLen) {
                        resLen = r - l + 1;
                    }
                    resL = l;
                    reR = r;

                    if(set.contains(s.charAt(l))){
                        map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                    }

                    l++;
                }
            }

        return resL == -1?"":s.substring(resL,reR+1);

    }

    private boolean isContainsAll(Map<Character, Integer> map,Set<Character> set){

        for(Character c:set){
            if(!map.containsKey(c))
                return false;
            if(map.get(c)<1)
                return false;
        }
        return true;



    }
}