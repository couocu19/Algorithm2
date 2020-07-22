package binarySearch;

import com.sun.jdi.VMMismatchException;

public class Search1 {
    public static void main(String[] args) {
        int[] nums = {5,1,3};
        int target = 1;
        Solution722 s = new Solution722();
        System.out.println(s.search(nums,target));



    }
}


class Solution722 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low<=high){
            mid = low+((high-low)>>1);
            if(nums[mid] == target)
                return mid;
            if(nums[mid]>target){
                if(target<=nums[high] && nums[mid]>nums[high]){
                    low = mid + 1;
                }else{
                    high = mid -1;
                }
            }else {
                if(target>=nums[low] && nums[mid]<nums[low]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

        }

//        if(low<nums.length && nums[low] == target)
//            return low;

        return -1;
    }
}