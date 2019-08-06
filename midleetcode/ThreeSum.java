package midleetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {


    }
}

class Solutionm {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        //特殊条件判定
        if(nums == null || len<3)
            return list;
        for(int i = 0;i<len;i++){
            if(nums[i]>0)  //如果当前数字大于0，则三数之和一定大于0，结束循环。
                break;
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int L = i+1;
            int R = len-1;
            while(L<R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum==0){
                    list.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while(L<R && nums[L] == nums[L+1])
                        L++;  //去重
                    while(L<R && nums[R] == nums[R-1])
                        R--;  //去重
                    L++;
                    R--;
                }
                else if (sum <0)
                    L++;
                else if (sum>0)
                    R--;
            }

        }
        return list;

    }
}

