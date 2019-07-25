package leetcode;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        Solution9 l = new Solution9();
        System.out.println(l.removeDuplicates(nums));

    }
}

class Solution9 {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        int length = nums.length;
        int i = 0;
        for(int j = 1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }

        }
        return i+1;


    }
}
