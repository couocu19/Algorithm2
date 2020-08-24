package two_principle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {-2,0,1,1,2};
        Solution15 s = new Solution15();
        System.out.println(s.threeSum1(nums));






    }
}


class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        int l ;
        int r ;
        int sum;
       for(int i =0;i<len;i++){
            l = i + 1;
            r = len - 1;
          // System.out.println(l + " " + r);
            while(l<r) {
              //  System.out.println(l + " " + r);
               // System.out.println(nums[i] +" "+ nums[l] +" "+nums[r]);
                sum = nums[i] + nums[l] + nums[r];
              //  System.out.println(sum);
                if (sum == 0) {
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    if(!res.contains(list)) {
                        res.add(list);
                    }
                    list = new ArrayList<>();
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        int sum;
        for(int i =0;i<len;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int r = len-1;
            int target = -nums[i];

            for(int l = i+1;l<len;l++){
                if(l>i+1 && nums[l] == nums[l-1]){
                    continue;
                }

                while (l<r && nums[l] + nums[r] >target){
                    --r;
                }

                if(l == r)
                    break;


                if(nums[l] +nums[r] == target){
                    list = new ArrayList<>();
                    list.add(nums[l]);
                    list.add(nums[r]);
                    list.add(nums[i]);
                    res.add(list);

                }
            }
        }
        return res;
    }
}