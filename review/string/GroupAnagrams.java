package review.string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {



    }
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s:strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String c = String.valueOf(ch);
            if(!map.containsKey(c)){
                map.put(c,new ArrayList<>());
            }
            map.get(c).add(s);
        }

        List<List<String>> list = new ArrayList<>();
        for(String s:map.keySet()) {
            list.add(map.get(s));
        }

        return list;
    }



}
