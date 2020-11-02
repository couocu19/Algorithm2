package dp;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {

        int m = 51;
        int n = 6;
        Solution62 s = new Solution62();
        System.out.println(s.uniquePaths(m,n));
        //System.out.println(s.get(m));
    }
}

class Solution62 {


    //思路：利用排列组合公式 Cmn = m!/n!(m-n)!
    //从m+n-2个元素中取(m-1)个元素
    public int uniquePaths(int m, int n) {
        long res = 1;
        for(int i =0;i<Math.min(m-1,n-1);i++){
            res *= (m+n-2-i);
            res /= (i+1);
        }

        return (int)res;
    }

    public int uniquePaths1(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for(int i =1;i<m;i++){
            for(int j =1;j<n;j++){
                cur[j] += cur[j-1];
            }

        }
        return cur[n-1];


    }

//    public int get(int  x){
//
//        if(x == 1)
//            return 1;
//        if(x == 2)
//            return 2;
//        else
//            return x*get(x-1);
//    }






}