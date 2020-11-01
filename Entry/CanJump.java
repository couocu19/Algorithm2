package Entry;

import java.util.Arrays;

public class CanJump {
    public static void main(String[] args) {


    }
}

class Solution55 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for(int i =0;i<n;i++){
            if(i<=rightmost){
                rightmost = Math.max(rightmost,i+nums[i]);
                if(rightmost >= n-1){
                    return true;
                }
            }

        }

        return false;


    }

    public boolean canJump1(int[] nums){
        int n = nums.length;
        int rightMax = 0;
        for(int i =0;i<n;i++){
            if(i<=rightMax){
                rightMax = Math.max(rightMax,i+nums[i]);
            }
            if(rightMax >= n-1){
                return true;
            }
        }
        return true;
    }
}