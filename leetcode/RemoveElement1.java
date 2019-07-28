package leetcode;

import java.util.Scanner;

public class RemoveElement1 {
    public static void main(String[] args) {
        //Scanner w = new Scanner(System.in);
        Solution11 a = new Solution11();
        int[] nums = {3,3,3,1,2,3,4,2,5};
        int val = 3;
        System.out.println(a.removeElement(nums,val));


    }
}

class Solution11{
    public int removeElement(int[] nums, int val){
        int length = 0;
        int t = 0;
        int[] n1 = new int[nums.length];
        for (int i = 0;i<nums.length;i++){
            if(nums[i]!=val){
                n1[t++] = nums[i];
            }
        }
        for(int i = 0;i<t;i++){
            nums[i] = n1[i];

        }


        return t;
    }


}
