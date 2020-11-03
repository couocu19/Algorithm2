package review.entry;

import java.util.ArrayList;
import java.util.List;

public class ThreeNum {
    public static void main(String[] args) {


    }
}

class S{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int k = 0;k<nums.length-2;k++){
            int i =k+1;
            int j = nums.length-1;
            while (i<j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    if(!res.contains(list)) {
                        res.add(list);
                    }
                    list = new ArrayList<>();
                    i++;
                    j--;
                } else if (sum > 0) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;

    }
}
