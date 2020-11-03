package review.binarySearch;

public class Search1 {
    public static void main(String[] args) {


    }


    public static int get(int[] nums,int target){
        int len = target;
        int left = 0;
        int right = len-1;

        while (left<=right){
            int mid = left+((right-left)>>1);
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]>=nums[left]){
                if(target>=nums[left] && target<=nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target>=nums[mid] && target<=nums[right]){
                    left = mid + 1;
                }else{
                    right = mid -1;

                }
            }

        }
        return -1;




    }
}


