package string;

public class LongestValidParentheses1 {
    public static void main(String[] args) {
        Solution32s s = new Solution32s();
        String s1 = "()((())";
        System.out.println(s.longestValidParentheses(s1));




    }
}

 class Solution32s {
    public int longestValidParentheses(String s) {
        int max  = 0 ;
        int len = s.length();
        int left = 0;
        int right = 0;
        for(int i =0;i<len;i++){
            if(s.charAt(i)  == '(')
                left++;
            if(s.charAt(i) == ')')
                right++;
            if(left == right){
                max = Math.max(max,2*right);
            }else if(right>left){
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

            if(left == right){
                max = Math.max(max,2*left);
            }else if(left>right){
                left = right = 0;
            }

        }
        return max;
    }
}


