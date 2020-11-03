package review.entry;

public class SingleNumber {
    public static void main(String[] args) {


    }
}

class Solution136 {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        if(nums.length>0){
            for(int i =1;i<nums.length;i++){
                ans = ans ^ nums[i];
            }
        }

        return ans;
    }
}