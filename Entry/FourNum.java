package Entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNum {

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        Solution18s s = new Solution18s();

        System.out.println(s.fourSum(nums,0));

    }
}

class Solution18s {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        int m,n;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0)
            return res;
        Arrays.sort(nums);
        for(int i =0;i<len;i++){
//            if(i>0&& nums[i] == nums[i-1] )
//                continue;
            for (int j=i+1;j<len;j++){
//                if(j>i+1 && nums[j] == nums[j-1])
//                    continue;
                m = j+1;
                n = len-1;
                while (m<n) {
                    sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[m]);
                        list.add(nums[n]);
                        if(!res.contains(list)) {
                            res.add(list);
                        }
                        list = new ArrayList<>();
                        m++;
                        n--;
                    } else if (sum > target) {
                            n--;
                        } else{
                            m++;
                    }
                }
            }
        }
        return res;
    }





}
