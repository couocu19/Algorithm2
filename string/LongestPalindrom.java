package string;

public class LongestPalindrom {
    public static void main(String[] args) {
        String s = "abba";
        Solutions s3 = new Solutions();
        System.out.println(s.substring(0,1));
        System.out.println(s3.isPalindromic(s));
        System.out.println(s3.longestPalindrome(s));



    }


}
//暴力求解：超出时间限制
class Solutions {
    //判断一个字符串是不是回文字符串
    public boolean isPalindromic(String s){
        int len = s.length();
        for(int i =0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)) {
                return false;
            }
        }
        return true;

    }
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        //遍历这个字符串的所有子串
        for(int i =0;i<len;i++){
            for(int j = i+1;j<=len;j++){
                //sustring(i,j)这个函数截取的范围:[i,j)!(左闭右开)
                String flag = s.substring(i,j);
                if(isPalindromic(flag) &&flag.length()>max){
                    ans = s.substring(i,j);
                    max = Math.max(max,ans.length());

                }

            }

        }

        return ans;

    }






    }


