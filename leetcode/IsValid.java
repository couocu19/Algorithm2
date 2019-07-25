package leetcode;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.Scanner;
public class IsValid {
    public static void main(String[] args) {
        Scanner w = new Scanner(System.in);
        String k = w.nextLine();
        Solution8 sss = new Solution8();

        System.out.println(sss.isValid(k));



    }
}
class Solution8 {
    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;
    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Solution8() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (this.mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != this.mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
