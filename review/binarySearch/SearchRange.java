package review.binarySearch;

public class SearchRange {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,4,4,4,5,6,7,8};

        System.out.println(findL(nums,4));
        System.out.println(findR(nums,4));




    }

    public static int findL(int[] nums,int target){
        int len = nums.length;
        int low = 0;
        int high = nums.length-1;
        int mid;
        while (low<high) {
            mid = low + ((high - low) >> 1);
            if (nums[mid] == target)
                high = mid;
            else if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        if(low!=len && nums[low] == target)
            return low;
        return -1;
    }


    public static int findR(int[] nums,int target){
        int low = 0;
        int high = nums.length;
        int mid;
        while (low<high){
            mid = low+((high-low)>>1);
            if(nums[mid] == target){
                low = mid+1;
            }
            else if(nums[mid]>target){
                high = mid;
            }else{
                low = mid+1;
            }
        }

        if(low!=0 && nums[low-1] == target)
            return low-1;
        return -1;
    }









}
