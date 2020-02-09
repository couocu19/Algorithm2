package Entry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicate2 {

    public static void main(String[] args) {
        Solution287s s = new Solution287s();
        int num[] = {1,2,2,3,4};
        System.out.println(s.findDuplicate(num));


    }
}

class Solution287s {
    public int findDuplicate(int[] nums) {
       Arrays.sort(nums);
       int len = nums.length;
       for(int i = 1;i<len;i++){
           if(nums[i]==nums[i-1]){
               return nums[i];
           }
       }
       return 0;
       

    }
}