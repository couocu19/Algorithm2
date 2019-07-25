package leetcode;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class IsValid1 {
    public static void main(String[] args) {
        Scanner w = new Scanner(System.in);
        String k = w.nextLine();
        Solve sss = new Solve();
        System.out.println(sss.idValid(k));


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
            if(this.m.containsKey(c)) {
                Character flag;
                //要考虑空栈的情况
                if (stack.isEmpty()) {
                    flag = '#';
                }
                else {
                    flag = stack.pop();
                }
                if (!flag.equals(m.get(c))) {
                    return false;
                }
            }
            else{
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }


}
