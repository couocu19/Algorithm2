package string;

public class LongestPalindrome3 {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        String s1 = "c";
        System.out.println(s.longestPalindrome(s1));

    }
}


class Solution5 {
    public String longestPalindrome(String s) {
        if(s.length()==1 ||s.equals("") ){
            return s;
        }
        int len = s.length();
        String s1 = null;
        String s2 = null;
        String result = null;
        String resultFlag = null;
        int max = -1;
        for(int i =0;i<len;i++){
           s1 = centerSpread(s,i,i);
           s2 = centerSpread(s,i,i+1);
            int maxLen = Math.max(s1.length(),s2.length());
            if(maxLen == s1.length()){
                resultFlag = s1;
            }else{
                resultFlag = s2;
            }
            if(maxLen>max){
                max = maxLen;
                result = resultFlag;

            }

        }
        return result;

    }


    public String centerSpread(String s1,int left,int right){
        int i = left;
        int j = right;
        int len = s1.length();
        while(i>=0 && j<len){
            if(s1.charAt(i)!=s1.charAt(j)){
                break;
            }else{
                i--;
                j++;
            }
        }

        return s1.substring(i+1,j);
    }
}