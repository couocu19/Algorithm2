package binarySearch;

public class FindPeakElement {
    public static void main(String[] args) {

        int[] nums = {1,2,1,3,5,6};
        Solution162 s = new Solution162();
        System.out.println(s.findPeakElement(nums));




    }
}

class Solution162 {

    //迭代二分法
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low<high){
            mid = low +((high -low)>>1);

            if(nums[mid]>nums[mid+1]){
                high = mid;

            }else{
                low = mid+1;
            }
        }

        return low;
    }
}
