package binarySearch;

public class BinarySearch2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3};
        int target  = 2;
        //System.out.println(bin2(nums,target));

        int[] nums1 = {4,5,6,7,1,2};
        System.out.println(binSearchRotate(nums1));

    }


    //模板二
    //二分查找左侧区间
    public static int bin2(int[] nums,int target){
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length;
        int mid;
        while(low<high){
//            System.out.println("1");
            mid = low+((high-low)>>1);
            if(nums[mid] == target){
                high = mid;
                //return mid; //??不太懂这里
            }else if(nums[mid]<target){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        if(low!=nums.length && nums[low] == target)
            return low;

        return -1;

    }

    //查找旋转数组的第一个元素
    //假设数组中没有重复元素
    public static int binSearchRotate(int[]  nums){
        int low = 0;
        int high = nums.length-1;
        int mid;
        while ((low<high)){
            mid = low+((high-low)>>1);
            //当首元素的值小于尾元素时，说明该区间已经是一个单增区间
            //即说明首元素是最小元素
            if(nums[low] < nums[high])
                return nums[low];

            //这里必须是大于等于条件
            if(nums[mid]>=nums[low]){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        return nums[low];
    }

}
