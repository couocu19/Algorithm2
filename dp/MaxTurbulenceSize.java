package dp;

public class MaxTurbulenceSize {
    public static void main(String[] args) {
        int[] A = {9,4,2,10,7,8,8,1,9};
        Solution978 s = new Solution978();
        System.out.println(s.maxTurbulenceSize(A));


    }
}


class Solution978 {
    public int maxTurbulenceSize(int[] A) {
        int len = A.length;
        if(len == 0)
            return 0;
        if(len == 1)
            return 1;
        if(len == 2 && A[0]!=A[1])
            return 2;
        if(len == 2 && A[0]==A[1])
            return 1;


        int[] dp = new int[len+1];
        for(int i =0;i<len+1;i++){
            dp[i] = 1;
        }

        int j;
        int pre = -1;
        int max = 1;
////
        if(A[1]!=A[0]){
            dp[1] = 2;
            max = 2;
        }
        int flag = 0;
        int flag1 = 0;
        for(int i =2;i<len;){
            flag = 0;
            for( j =i;j<(len)&&flag==0;j++){
                if ((A[j]>A[j-1] && A[j-1]<A[j-2]) ||
                        (A[j]<A[j-1] && A[j-1]>A[j-2])){
                    if(dp[j] == 1){
                        dp[j]+=1;
                    }else {
                        dp[j] = dp[j-1] + 1;
                    }
                    max = Math.max(dp[j],max);
                 //   System.out.println("ok"+" "+max);
                }
                else{
                    if(A[j] == A[j-1]) {
                        dp[j] = dp[j - 1];
                    }else{


                    }
                    flag = 1;
                    max = Math.max(dp[j],max);
                }
            }
            i = j ;
            dp[i] = 1;
            //System.out.println(i+" "+max);
            }
        return max;
    }
}