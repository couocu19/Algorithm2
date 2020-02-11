package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

    public static void main(String[] args) {


    }
}

class Solution17s {
    private Map<Character, String> map;
    private List<String> result = new ArrayList<>();
    private String digits;
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return result;

        this.digits = digits;
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        helper("", 0);
        return result;
    }

    private void helper(String profix, int index) {
        if (index == digits.length()) {
            result.add(profix);
            return;
        }
        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++)
            helper(profix + s.charAt(i), index + 1);

    }
}

