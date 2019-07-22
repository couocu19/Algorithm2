package leetcode;

import java.text.ParseException;
import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution a = new Solution();

        //要确定数组维
        int[] array = new int[2];

        array = a.twoSum(nums,target);
        //直接输出数组的方法
        System.out.println(Arrays.toString(array));

    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");

    }
}