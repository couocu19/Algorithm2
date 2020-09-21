package Entry;

import java.util.Arrays;

public class FindDuplicate3 {
    public static void main(String[] args) {
        int[] nums = {4,3,1,0,2,5,3};

        Solution287ss s = new Solution287ss();
        System.out.println(s.findDuplicate(nums));
    }
}


//二分查找+循环 时间复杂度 O(nlogn)
class Solution287ss {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len-1;
        //int mid = (left+right)/2;
        int cnt;
        while(left<=right){
            cnt = 0;
            int mid = (left+right)/2;
            for(int num:nums){
                if(num<=mid){
                    cnt++;
                }
            }

            if(cnt>mid){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;

    }
}
