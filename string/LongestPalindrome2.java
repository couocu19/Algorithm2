package string;


public class LongestPalindrome2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "bd";

        System.out.println(s.longestPalindrome(s1));
        System.out.println(s.isPalind(s1));
    }


}

class Solution {
    //超出时间限制
    public String longestPalindrome(String s) {
        int len = s.length();
        String result = null;
        int rLen = -1;
        int i;
        int j;
        if(s.equals("") || len == 1){
            return s;
        }
        for(i = 0;i<len;i++){
            for(j = i;j<len;j++){
                String flag = s.substring(i,j+1);
                if(isPalind(flag) && (j-i)>rLen){
                    result = flag;
                    rLen = j-i;
                }
            }

        }
        return  result;

    }

    public boolean isPalind(String s){
        boolean flag = true;
        int len = s.length();
        int i;
        int j;
        if(s.length() == 1){
            return true;
        }

        for(i = 0,j = len-1;i<len/2;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                flag = false;
                break;
            }
        }
        if(i == len/2){
            flag = true;

        }
        return flag;
    }

}

