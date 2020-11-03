package review.string;

public class LongestValidParentheses {
    public static void main(String[] args) {


    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int max = -1;
        for(int i =0;i<len;i++){
            if(s.charAt(i) == '(')
                left++;
            else
                right++;
            if(left == right){
                max = Math.max(max,left*2);
            }
            if(right>left) {
                left = right = 0;
            }
        }

        left = 0;
        right = 0;

        for(int i =len-1;i>=0;i--){
            if(s.charAt(i) == '(')
                left++;
            if(s.charAt(i) == ')')
                right++;

            if(left == right)
                max = Math.max(max,right*2);
            if(left>right){
                left = right = 0;
            }
        }

        return max;




    }
}