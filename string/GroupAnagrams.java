package string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {


    }
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        Map<String,List> ans = new HashMap<>();
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList());
            }
            ans.get(key).add(s);
        }
        for(String s : ans.keySet()){
            res.add(ans.get(s));

        }

        return res;
    }


    public List<List<String>> groupAnagrams1(String[] strs){
        Map<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        List<List<String>> list = new ArrayList<>();
        for(String s:map.keySet()){
            list.add(map.get(s));
        }

        return list;


    }
}