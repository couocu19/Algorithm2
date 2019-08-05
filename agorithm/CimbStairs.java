package agorithm;

public class CimbStairs {
    public static void main(String[] args) {
        Solutionl w = new Solutionl();
        System.out.println(w.climbStairs(3));

    }
}
class Solutionl {
    //爬楼梯问题
    //到第i个楼梯的爬楼梯方法总数等于第(i-1)个阶梯的方法总数加上第(i-2)个阶梯的方法总数
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        int[] sum = new int[n+1];
        sum[1] = 1;
        sum[2] = 2;
        for(int i = 3;i<=n;i++){
          sum[i] = sum[i-1]+sum[i-2];
        }
        return sum[n];



    }
}

