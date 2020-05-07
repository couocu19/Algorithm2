package Entry;

import java.util.Arrays;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int nums1[] = {1,2};
        int nums2[] = {3,4};
        int nums3[] = new int[4];

        Solution4 s = new Solution4();
        Solution4s s1 = new Solution4s();
        System.out.println(s1.findMedianSortedArrays(nums1,nums2));

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

class Solution4s{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //合并两数组合并后数组长度是偶数的情况,如果合并后的数组长度是偶数,会得到两个相同的值
        //left和right分别表示合并后数组中位数所在的位置(不是位置所对应的下标)
        int left = (m+n+1)/2;
        int right = (m+n+2)/2;
        return (getKth(nums1,0,m-1,nums2,0,n-1,left)+
                getKth(nums1,0,m-1,nums2,0,n-1,right))*0.5;
    }

    private int getKth(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        int len1 = end1 - start1+1;
        int len2 = end2 - start2+1;
        //保证len1始终为比较小的那一个
        if(len1>len2)
            return getKth(nums2,start2,end2,nums1,start1,end1,k);
        if(len1 == 0)
            return nums2[(start2+k)-1];
        if(k == 1)
            return Math.min(nums1[start1],nums2[start2]);

        //防止数组的长度比k/2还小
        int i = start1 + Math.min(len1,k/2) -1;
        int j = start2 + Math.min(len2,k/2) -1;

        if(nums1[i]>nums2[j]){
            return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }else{
            return getKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));

        }

    }





}
