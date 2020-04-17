package Entry;

import java.util.ArrayList;
import java.util.List;

//找出数组中重复的数字序列
public class findDuplicates {
    public static void main(String[] args) {
        int nums[] = {4,7,8,2,3,2,3,1};
        Solution442 s = new Solution442();
        System.out.println(s.findDuplicates(nums));

    }
}

class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        int len = nums.length;
        int flag = len;
        int index = 0;
        int num;
        List<Integer> result = new ArrayList<>();
         for(int i =0;i<len;i++){
            index = Math.abs(nums[i])-1;
            if (nums[index] < 0) {
                    //if(!result.contains(Math.abs(index+1))) {
                        result.add(Math.abs(index + 1));
                   // }
            }
            nums[index] = -nums[index];
        }

        return result;
        }

    }

