package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EtterCombinations {
    public static void main(String[] args) {
        String str1 = "23";
//        Map<Character,String> map = new HashMap<>();
//        map.put('2',"abc");
//        map.put('3',"def");
//        map.put('4',"ghi");
//        map.put('5',"jkl");
//        map.put('6',"mno");
//        map.put('7',"pqrs");
//        map.put('8',"tuv");
//        map.put('9',"wxyz");
        Solution17 s = new Solution17();
        //System.out.println(s.howMany(map,str1));

    }
}


class Solution17 {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> result = new ArrayList<>();
        int lens = howMany(map,digits);
        String[] strings = new String[lens];
        int len = digits.length();
        char[] string = digits.toCharArray();

        String[] strings1 = new String[len];

        for(int i =0;i<len;i++){
            String s1 = map.get(string[i]);
            strings1[i] = s1;

        }
        StringBuilder sb = new StringBuilder("");
        for(int i =0;i<len;i++){
            int len2 = strings1[i].length();

            sb.append(strings1[i].charAt(0));


        }



        return null;

    }

    public int howMany(Map<Character,String> map,String num){
        int len = num.length();
        int result = 1;
        for(int i =0;i<len;i++){
            int len1 = map.get(num.charAt(i)).length();
            result  = result*len1;
        }
        return result;
    }
}

