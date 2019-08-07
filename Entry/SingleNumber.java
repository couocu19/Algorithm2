package Entry;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1,1,3,2,3,2,5,6,6,7,7};
        SolutionM s = new SolutionM();
        System.out.println(s.singleNumber(nums));

    }
    }
    class SolutionM {
        public int singleNumber(int[] nums) {
            int num = 0;
            int i = 0;
            Arrays.sort(nums);
            for(int j =1;j<nums.length-1;j++){
                if(nums[j]!=nums[i]){
                    if((j-i)==1){
                        num = nums[i];
                        return nums[i];
                    }else{
                        i += 2;
                    }
                }
        }
            return nums[nums.length-1];


    }
}
