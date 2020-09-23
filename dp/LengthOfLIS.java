package dp;

public class LengthOfLIS {

    public static void main(String[] args) {
        int[] num  = {10,9,2,5,3,4};
        Solution300 s = new Solution300();
      //  System.out.println(s.lengthOfLIS(num));

        Solution300s s1 = new Solution300s();
        System.out.println(s1.lengthOfLIS1(num));


    }
}


class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int tmp = 1;
        int flag;
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<len;i++){
            tmp = 1;
            flag = nums[i];
            for(int j =i+1;j<len;j++){
                if(nums[j]>flag){
                    System.out.print(nums[j]+" ");
                    flag = nums[j];
                    tmp++;
                }
            }

            System.out.println();
            res = Math.max(tmp,res);
        }

        return res;

    }
}

class Solution300s{

    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for(int i =1;i<dp.length;i++){
            int maxval = 0;
            for(int j =0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxval = Math.max(maxval,dp[j]);
                }
            }
            dp[i] = maxval+1;
            maxans = Math.max(maxans,dp[i]);
        }
        return maxans;
    }

    public int lengthOfLIS1(int[] nums){
        int len = nums.length;
        if(len == 0)
            return 0;
        int[] dp = new int[len+1];
        int res = 1;
        int maxval;

        for(int i =1;i<len;i++){
            //每次进行到一个i的时候，就将i之前的字符的最长升序序列设置为0，因为要重新开始遍历
            maxval = 0;
            for(int j =0;j<i;j++){
                //要能从dp[j]这个状态转过来，那么nums[i]必须大于nums[j]
                if(nums[i]>nums[j]){
                    //状态转移方程
                    maxval = Math.max(dp[j],maxval);
                }
            }
            dp[i] = maxval+1;
            res = Math.max(res,dp[i]);
        }


        return res;


    }

}