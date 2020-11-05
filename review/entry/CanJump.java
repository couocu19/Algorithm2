package review.entry;

public class CanJump {
    public static void main(String[] args) {



    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int rightMax = 0;
        int len = nums.length;
        for(int i =0;i<len;i++){
            if(i<=rightMax){
                rightMax = Math.max(rightMax,i+nums[i]);
                if(rightMax>=len-1)
                    return true;
            }

        }

        return false;




    }

    public boolean canJump1(int[] nums) {
        int len = nums.length;
        int rightmax = 0;
        for(int i =0;i<len;i++){
            if(i<=rightmax){
                rightmax = Math.max(rightmax,nums[i]+i);
                if(rightmax>=len-1){
                    return true;
                }
            }
        }

        return false;


    }



}