package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid1 {
    public static void main(String[] args) {


    }
}
class Solve{
    private HashMap<Character,Character> m;
    public Solve(){
        this.m = new HashMap<>();
        m.put(')','(');
        m.put(']','[');
        m.put('}','{');

    }

    public boolean idValid(String s){

        Stack<Character> stack = new Stack<>();

        for(int i = 0;i<s.length();i++){
            Character c = s.charAt(i);

            if(this.m.containsKey(c)){
                Character flag =

            }else{
                stack.push(c);
            }

        }


    }


}
