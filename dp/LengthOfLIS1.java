package dp;

public class LengthOfLIS1 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(getMax1(nums));




    }



    public static int getMax(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int res = 1;
        for(int i =1;i<len;i++){
            int max = 0;
            for(int j =0;j<i;j++){
                if(nums[i]>nums[j]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max+1;
            res = Math.max(res,dp[i]);
        }

        return res;




    }


    public static int getMax1(int[] nums){
        int len = nums.length;
        int res = 1;
        int max;
        int[] dp = new int[len];
        for(int i =1;i<len;i++){
            max = 0;
            for(int j =0;j<i;j++){
                if(nums[i]>nums[j]){
                    max = Math.max(dp[j],max);
                }
            }
            dp[i] = max+1;
            res = Math.max(dp[i],res);
        }
        return res;
    }
}




