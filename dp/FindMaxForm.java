package dp;

public class FindMaxForm {

    public static void main(String[] args) {
        String[] strs = {"10","1","0"};
        int m = 1;
        int n = 1;
        Solution474 s = new Solution474();
        System.out.println(s.findMaxForm(strs,m,n));



    }
}

class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        //int len = strs.length;
        int len;
        int a = 0; //用来标记"1"
        int b = 0; //用来标记"0"
        int[][] dp = new int[m+1][n+1];
        //用来标记当前使用完的字符
        int j = 0;
        int k = 0;
        for(String s:strs){
            len = s.length();
            a = 0;
            b = 0;
            for(int i =0;i<len;i++){
                if(s.charAt(i) == '1'){
                  a++;
                }else{
                  b++;
                }
            }
            //动态规划状态转移方程
            for( j = m;j>=b;j--){
                for( k = n;k>=a;k--){
                    dp[j][k] = Math.max(1+dp[j-b][k-a],dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }
}