package string;

import java.util.*;

//括号匹配
public class Brackets {

    public static void main(String[] args) {
        String b = ")}{({))[{{[}";
        String b1 = "[[[]]]";
        System.out.println(isMatched1(b));
        Solution20 s = new Solution20();
        System.out.println(s.isValid(b));


    }

    //只限于输入一种办法符号的情况
    public static String isMatched(String brackets){
        List<Character> list = new ArrayList<>();

        list.add('(');
        list.add('<');
        list.add('{');
        list.add('[');
        int len = brackets.length();
        int left = 0;
        int right = 0;
        for (int i =0;i<len;i++){
            if(list.contains(brackets.charAt(i))){
                left++;
            }else{
                right++;
            }
        }
        if(right == left){
            return "yes";
        }else{
            return "no";
        }
    }

    //输入多种括号
    public static String isMatched1(String brackets){
        Map<Character,Integer> map = new HashMap<>();
        map.put('[',0);
        map.put('{',0);
        map.put('<',0);
        map.put('(',0);

        map.put(']',0);
        map.put('}',0);
        map.put(')',0);
        map.put('>',0);
        int len = brackets.length();
        if(len%2 == 1){
            return "no";
        }
        for(int i =0;i<len;i++){
           int num =  map.get(brackets.charAt(i));
           num++;
           map.put(brackets.charAt(i),num);
        }
        if(map.get('{') == map.get('}') && map.get('[') == map.get(']')&&
        map.get('(') == map.get(')') && map.get('<') == map.get('>')){
            return "yes";
        }

        return "no";


    }
}

class Solution20 {
    public boolean isValid(String s) {
        if(s.equals("")){
            return false;
        }
        Stack stack = new Stack();
        int len = s.length();
        if(len%2 == 1){
            return false;
        }
        Map<Character,Character>map = new HashMap<>();
        map.put('<','>');
        map.put('[',']');
        map.put('{','}');
        map.put('(',')');

        stack.push('#');
        for(int i =0;i<len;i++){
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }else {
                Character c = (Character) stack.peek();
                if(c == '#'){
                    return false;
                }
                if ( map.get(c )== s.charAt(i)) {
                    stack.pop();
                }
            }
        }
        Character n = (Character) stack.peek();
        if(n == '#'){
            return true;
        }
        return false;

    }
}