package top100;

import java.util.Arrays;

public class No136 {
    public static void main(String[] args) {
        int[] nums = {1,4,1,2,2,5,4};
        Solution136 s = new Solution136();
        System.out.println(s.singleNumber1(nums));

    }
}

class Solution136 {
    //这个写法很慢
    public int singleNumber(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return nums[0];
        Arrays.sort(nums);
        if(nums[0]!=nums[1])
            return nums[0];
        for(int i = 2;i<len-1;i++){
            if(nums[i]!=nums[i-1] && nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return nums[len-1];
    }

    public int singleNumber1(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        for(int i = 1;i<len;i++){
            res = res ^ nums[i];
        }

        return res;

    }
}