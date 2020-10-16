package dp;

public class CuttingRope {
    public static void main(String[] args) {

        Solution14 s = new Solution14();
        int n = 9;
        System.out.println(s.cuttingRope(n));

    }
}

class Solution14 {
    public int cuttingRope(int n) {
       if(n<2)
           return 0;
       if(n == 2)
           return 1;
       if(n == 3)
           return 2;
        int max = 0;
        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i =4;i<=n;i++){
            max = 0;
            for(int j =1;j<=i/2;j++){
                int m = dp[j]*dp[i-j];
                if(max<m)
                    max = m;

                dp[i] = max;
            }
        }
        max = dp[n];
        return max;
    }

    public int cuttingRope1(int n){
        if(n<2)
            return 0;
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;

        //尽可能多地剪去长度为3的绳子段
        int timesOf3 = n/3;

        //当绳子最后剩下的长度为4的时候，不能再减去长度为3的绳子段
        if(n-timesOf3*3 == 1)
            timesOf3-=1;

        int timesOf2 = (n-timesOf3*3)/2;

        return (int)(Math.pow(3,timesOf3))*(int)(Math.pow(2,timesOf2));

    }

    public int cuttingRope2(int n){
        if(n<2)
            return 0;
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;

        int n3 = n/3;
        if(n-n3*3 == 1)
            n3-=1;

        int n2 = (n-n3*3)/2;

        return (int)(Math.pow(3,n3))*(int)(Math.pow(2,n2));


    }
}