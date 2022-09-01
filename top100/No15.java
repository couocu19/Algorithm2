package top100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15 {
    public static void main(String[] args) {
        int[] nums = {0,0,0};
        Solution15 s = new Solution15();
        System.out.println(s.threeSum(nums));


    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        if(len<3)
            return null;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int l;
        int r;
        int sum;
        for(int i = 0;i<(len-2);i++){
            if(nums[i]>0)
                break;
            if(i>0 && nums[i] == nums[i-1])
                continue;
            l = i+1;
            r = len-1;
            while (l<r){
                sum = nums[i]+nums[l]+nums[r];
                if(sum>0){
                    r--;
                }else if(sum<0){
                    l++;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    list = new ArrayList<>();
                    l++;
                    r--;
                    if(l<r && nums[l] == nums[l-1])
                        continue;
                    if(r>l && nums[r] == nums[r+1])
                        continue;
                }
            }
        }
        return res;
    }
}