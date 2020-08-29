package backtrack;

public class ClimbStairs {
    public static void main(String[] args) {

        int n = 3;
        Solution70 s = new Solution70();
        System.out.println(s.climbStairs(n));


    }



}

//超出时间限制了。。
class Solution70 {

    private  int sum = 0;
    public int climbStairs(int n) {
        backtrack(n,0);
        return sum;
    }

    private void backtrack(int n,int s){
        if(s == n){
            sum = sum+1;
            return;
        }


        if(s<n){
            backtrack(n,s+1);
        }

        if((s+1)<n){
            backtrack(n,s+2);
        }

    }
}
