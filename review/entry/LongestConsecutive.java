package review.entry;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutive {
    public static void main(String[] args) {


    }
}

class Solution128 {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<len;i++){
            if(map.containsKey(nums[i]))
                continue;
            int left = map.getOrDefault(nums[i] - 1,0);
            int right = map.getOrDefault(nums[i] + 1,0);
            int L = left + right +1;
            res = Math.max(res,L);
            map.put(nums[i],L);
            map.put(nums[i] - left,L);
            map.put(nums[i] + right,L);
        }

        return res;

    }

    public int longestConsecutive1(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        int res = 0;
        for(int i =0;i<len;i++){
            if(map.containsKey(nums[i]))
                continue;
            int left = map.getOrDefault(nums[i] - 1,0);
            int right = map.getOrDefault(nums[i] + 1,0);
            int L = left+right+1;
            res = Math.max(res,L);

            map.put(nums[i],L);
            map.put(nums[i] - left,L);
            map.put(nums[i] + right,L);
        }

        return res;




    }
}