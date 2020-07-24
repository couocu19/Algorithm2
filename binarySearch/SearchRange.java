package binarySearch;

public class SearchRange {
    public static void main(String[] args) {
        int[] nums = {5,7,7,7,7,7,7,7,7,8};
        int target = 7;
        Solution34s s = new Solution34s();
      //  System.out.println(s.searchRange(nums,target));
        for(int a:s.searchRange(nums,target)){
            System.out.println(a);
        }




    }

}

class Solution34 {

    private int[] result = {-1,-1};
    private int[] nums;
    private int target;
    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        find(0,nums.length,0);
        return result;
    }

    private void find(int low,int high,int flag){
        if(low == high && flag == -1 && nums[low] == target){
            result[0] = low;
            return;
        }else if(low == high && flag == 1 && nums[low] == target){
            result[1] = low;
            return;
        }

        int mid = low+((high-low)>>1);
        if(nums[mid] == target){
            //查找左边界
            find(low,mid,-1);
            //查找右边界
            find(low+1,high,1);
        }

        else if(nums[mid]>target){
            find(low,mid,-1);

        }else{
            find(mid+1,high,1);
        }


    }
}

class Solution34s {

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        result[0] = find(nums,target,-1);
        result[1] = find(nums,target,1);

        return result;


    }

    private int find(int[] nums,int target,int flag){
        int low = 0;
        int high = nums.length;
        int mid;
        while(low<high){
            mid = low+((high-low)>>1);
            if(nums[mid] == target){
                if(flag == -1){
                    high = mid;
                }else if(flag == 1){
                    low = mid+1;
                }
            }
            else if(nums[mid]>target){
                high = mid;
            }else{
                low = mid+1;
            }
        }

        if(flag == -1){
            if(low!=nums.length && nums[low] == target)
                return low;
        }else{

            if(low!=0 && nums[low-1] == target)
                return low-1;

        }
        return -1;
    }



}