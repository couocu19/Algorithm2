package Entry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {

        int[] nums = {3,3,2,1,4,5,6,4};
        Solution448 s = new Solution448();

        System.out.println(s.findDisappearedNumbers(nums));


    }
}


class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i =0;i<nums.length;i++){
            int newIndex = Math.abs(nums[i]) -1;

            if(nums[newIndex] > 0){
                nums[newIndex] *= -1;

            }

        }

        List<Integer> result = new LinkedList<>();

        for(int i =1;i<=nums.length;i++){

            if(nums[i-1] >0){
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums){
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<len;i++){
            int newIdx = nums[i]-1;

            if(nums[newIdx]>0) {
                nums[newIdx] *= -1;
            }
        }

        for(int i =1;i<=len;i++){
            if(nums[i-1]>0){
                list.add(i);
            }
        }

        return list;







    }
}