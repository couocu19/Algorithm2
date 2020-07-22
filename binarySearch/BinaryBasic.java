package binarySearch;

public class BinaryBasic {
    public static void main(String[] args) {

        int[] nums = {1,2,4,5,6,7,9,10};
        int target = 99;
        System.out.println(findL(nums,target));


    }


    public static int findL(int[] nums,int target){
        if(nums == null || nums.length == 0)
            return -1;

        int low = 0;
        int high = nums.length-1;
        int mid;

        while(low<=high){

            //这里(high-low)>>1记得要加括号
            mid = low+((high-low)>>1);
            if(nums[mid] == target)
                return mid;
            else if(nums[mid]>target){
                high = mid-1;

            }else {
                low = mid+1;
                //System.out.println(low);

            }
        }

        return -1;
    }
}
