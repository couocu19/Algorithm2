package review.string;

public class LongestPalindrome {
    public static void main(String[] args) {
        String s = "ababa";
        Solution5 so = new Solution5();
        System.out.println(so.longestPalindrome(s));



    }
}


class Solution5 {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <1)
            return "";

        int len = s.length();
        int start = 0;
        int end = 0;
        for(int i =0;i<len;i++){
            int c1 = centerSpread(s,i,i);
            int c2 = centerSpread(s,i,i+1);
            int maxLen = Math.max(c1,c2);
            if(maxLen > (end-start)){
                start = i - (maxLen-1)/2;
                end = i+ maxLen/2;
            }
        }

        return s.substring(start,end+1);
    }

    private int centerSpread(String s,int left,int right){
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }

        return right-left-1;

    }
}

class Solution5s {
    public String longestPalindrome(String s) {
        if(s == null || s.length()<1)
            return "";
        int left = 0;
        int right = 0;
        int start = 0,end = 0;
        for(int i =0;i<s.length();i++){
            int c1 = centerSpread(s,i,i);
            int c2 = centerSpread(s,i,i+1);
            int maxL = Math.max(c1,c2);
            if(maxL>end-start){
                start = i - (maxL-1)/2;
                end = i + (maxL)/2;
            }
        }

        return s.substring(start,end+1);
    }

    private int centerSpread(String s,int left,int right){
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }

        return right-left-1;
    }
}
