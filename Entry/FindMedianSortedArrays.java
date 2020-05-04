package Entry;

import java.util.Arrays;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int nums1[] = {1,2};
        int nums2[] = {3,4};
        int nums3[] = new int[4];

        Solution4 s = new Solution4();


        System.out.println(s.findMedianSortedArrays(nums1,nums2));


    }
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        int nums3[] = new int[len];
        System.arraycopy(nums1,0,nums3,0,nums1.length);
        System.arraycopy(nums2,0,nums3,nums1.length,nums2.length);
        int low = 0;
        int high = len-1;
        int mid = (low+high)/2;
        int pos;
        while(true){
             pos = partition(nums3,low,high);
            if(pos == mid)
                break;
            if(pos>mid)
                high = pos-1;
            else if(pos<mid)
                low = pos+1;
        }

        double result;
        if(len%2 == 1){
           // System.out.println(nums3[pos]);
           result = nums3[pos];
            return result;
        }else{
            result = Double.MAX_VALUE;
           for(int i =pos+1;i<len;i++){
               if(nums3[i]<result)
                   result = nums3[i];
           }
           result = (double) (nums3[pos]+result)/2;
            return result;
        }

    }

    private int partition(int[] nums,int low,int high){
        int key = nums[low];
        while(low<high){
            while(low<high && nums[high]>=key)
                high--;
            nums[low] = nums[high];

            while(low<high && nums[low]<=key)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = key;
        return low;
    }
}
