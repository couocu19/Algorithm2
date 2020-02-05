package Entry;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicate {

    public static void main(String[] args) {
        Solution287 s = new Solution287();
        int num[] = {3,1,3,4,2};
        System.out.println(s.findDuplicate(num));



    }
}

class Solution287 {
    public int findDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for(int i =0;i<len;i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);

        }
        return 0;

    }
}
