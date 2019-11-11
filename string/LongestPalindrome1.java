package string;

public class LongestPalindrome1 {
    public static void main(String[] args) {

        Solutionkkk s = new Solutionkkk();
        String s1 = "babad";
        System.out.println(s.longestPalindrome(s1));

    }
}

class Solutionkkk {
       public String longestPalindrome(String s) {
        if(s.equals("")){
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int maxlen = -1;
        int maxend = 0;
        int len = s.length();
        int ans[][] = new int[len][len];
        for(int i = 0;i<len;i++){
            for(int j = 0;j<len;j++){
                if(origin.charAt(i) == reverse.charAt(j)){
                    if(i == 0|| j == 0){
                        ans[i][j] = 0;
                    }else{
                        ans[i][j] = ans[i-1][j-1]+1;
                    }
                }

                if(ans[i][j]>maxlen){
                    //检查最长子串是不是回文字符串
                    //在该题中检查下标是否对应
                    int before = len -1 -j;
                    if(before+ans[i][j] -1 == i){
                        maxlen = ans[i][j];
                        maxend = i;
                    }
                }

            }
        }
        return s.substring(maxend -maxlen+1 ,maxend +1);

    }

}
