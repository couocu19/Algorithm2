package review.binarySearch;

public class FindMin {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        Solution153 s = new Solution153();
        System.out.println(s.findMin(nums));
    }
}


class Solution153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        int low = 0;
        int high = len-1;
        int mid;
        while ((low<high)){
            mid = low+((high-low)>>1);
            if(nums[low]<nums[high]){
                return nums[low];
            }
            if(nums[mid]>=nums[low]){
                low = mid+1;
            }else {
                high = mid;
            }
        }

        return nums[low];

    }
}