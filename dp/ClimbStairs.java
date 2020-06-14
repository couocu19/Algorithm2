package dp;

public class ClimbStairs {

    public static void main(String[] args) {
        Solution70 s = new Solution70();
        System.out.println(s.climbStairs1(3));


    }
}


class Solution70 {
    //动态规划解决爬楼梯
    public int climbStairs(int n) {
        int p = 0,q = 0,r = 1;
        for(int i =1;i<=n;i++){
            p = q;
            q = r;
            r = p+q;
        }
        return r;
    }

    public int climbStairs1(int n) {

        if(n<2)
            return 1;
        int sum[] = new int[n+1];
        sum[0] = sum[1] = 1;
        for(int i =2;i<=n;i++){
            sum[i] = sum[i-1]+sum[i-2];
        }
        return sum[n];




    }

}