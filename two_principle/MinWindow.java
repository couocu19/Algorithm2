package two_principle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        String s = "ADDBECODEBANC";
        String t = "ABC";
        Solution76 so = new Solution76();
        System.out.println(so.minWindow1(s,t));



    }

}

class Solution76 {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        Map<Character,Integer> map = new HashMap<>();
        for(Character c:t.toCharArray()){
            map.put(c,-1);
        }

        int flag = len2;
        int flagLen = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<len1;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                if(min>i){
                    min = i;
                }
                if(max<i){
                    max = i;
                }

            }

        }

        return "";
    }

    Map<Character,Integer> ori = new HashMap<>();
    Map<Character,Integer> cnt = new HashMap<>();


    public String minWindow1(String s, String t){
        int tLen = t.length();
        for(int i=0;i<tLen;i++){
            char c = t.charAt(i);
            ori.put(c,ori.getOrDefault(c,0)+1);
        }
        int l = 0,r = -1;
        int len = Integer.MAX_VALUE,ansL = -1,ansR = -1;
        int sLen = s.length();

        while(r<sLen){
            ++r;
            if(r<sLen && ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0)+1);
            }

            while(check() && l<=r){
                if(r - l+1<len){
                    len = r-l+1;
                    ansL = l;
                    ansR = l+len;
                }

                if(ori.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0)-1);
                }
                ++l;
            }
        }

        return ansL == -1?"":s.substring(ansL,ansR);


    }

    private boolean check(){
        Iterator iter = ori.entrySet().iterator();

        while(iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();

            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();

            if(cnt.getOrDefault(key,0)<val){
                return false;
            }

        }

        return true;
    }


}