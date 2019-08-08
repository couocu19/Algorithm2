package dp;

public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        Solutiondp s = new Solutiondp();
        System.out.println(s.maxProduct(nums));

    }
}

class Solutiondp {
    public int maxProduct(int[] nums) {
        int max = -1;
        int sum = 1;
        if(nums.length == 1)
            return nums[0];
        for(int i =0;i<nums.length;i++){
            //有可能最大的乘积是某个数本身！
            max = Math.max(max,nums[i]);
            sum = nums[i];
            for(int j= i+1;j<nums.length;j++){
                sum *= nums[j];
                max = Math.max(sum,max);
            }
        }

        return max;
    }
}

