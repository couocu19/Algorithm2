package agorithm;

public class ClimbStairs1 {
    public static void main(String[] args) {

        Solution70 s = new Solution70();
        System.out.println(s.climb_Stairs1(5));
    }
}

//直接递归 时间复杂度为O(2^n)
//超出时间限制
class Solution70 {
    public int climbStairs(int n) {

       //return climb_Stairs(0,n);
        return climb_Stairs1(n);
    }

    public int climb_Stairs(int i,int n){
        if(i>n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        return climb_Stairs(i+1,n)+climb_Stairs(i+2,n);

    }

    public int climb_Stairs1(int n){
        int sum[] = new int[n+1];
        if(n == 1){
            return 1;
        }
        sum[1] = 1;
        sum[2] = 2;
        for(int i =3;i<=n;i++){
            sum[i] = sum[i-1] +sum[i-2];
        }
        return sum[n];
    }
}


