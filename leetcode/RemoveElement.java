package leetcode;

import java.util.ArrayList;

import java.util.List;

public class RemoveElement {

    public static void main(String[] args) {

    }
}

class Solution10 {
    public int removeElement(int[] nums, int val) {
        int length = 0;
        List<Integer> stack = new ArrayList<>();

        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=val){
                stack.add(nums[i]);
            }
        }
        length = stack.size();

        for(int i = 0;i<length;i++){

            nums[i] = stack.get(i);
        }

        return length;
    }
}
