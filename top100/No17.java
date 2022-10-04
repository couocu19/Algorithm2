package top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No17 {
    public static void main(String[] args) {
        String str = "234";
        Solution17 s = new Solution17();
        System.out.println(s.letterCombinations(str));


    }
}

class Solution17 {
    private List<String> list = new ArrayList<>();
    private Map<Character,String> map= new HashMap<>(){
        {
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }
    };
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if(len == 0)
            return null;
        backtrack("",digits);
        return list;
    }
    private void backtrack(String start,String next){
        if(next.length() == 0){
            list.add(start);
            return;
        }
        String s = map.get(next.charAt(0));
        for(int i = 0;i<s.length();i++){
            String p = s.substring(i,i+1);
            backtrack(start+p,next.substring(1));
        }
    }
}
