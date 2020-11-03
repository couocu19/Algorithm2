package review.entry;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {



    }
}

class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<len;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }

            map.put(target-nums[i],i);

        }

        return null;

    }



}