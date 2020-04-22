package Entry;

import java.util.Arrays;

public class KMax {
    public static void main(String[] args) {
        Solution215 s = new Solution215();
        int nums[] = {1,2,3,4,5,6,7};
        int k = 5;
      //  System.out.println(s.findKthLargest(nums,k));

        Solution215s s1 = new Solution215s();
        System.out.println(s1.findKthLargest(nums,k));

    }
}

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        int flag = 0;
        for(int i =nums.length-1;i>=0;i--){
            flag++;
            if(flag == k){
                return nums[i];
            }
        }
        return 0;

    }
}

class Solution215s {
    public int findKthLargest(int[] nums, int k) {
        int result[] = new int[k];
        int k1;
        for(int i =0;i<k;i++){
            result[i] = Integer.MIN_VALUE;
        }
        int len = nums.length;

        for(int i =0;i<len;i++){
            if(nums[i]>result[0]){
                result[0] = nums[i];
                adjustHeap(result,0,k);

            }
        }
        sort(result);
        for(int a:result){
            System.out.println(a);
        }

        return result[k-1];

    }



    private void adjustHeap(int[] nums,int index,int len){
        int left = 2*index+1;
        int right = 2*index+2;
        int minIndex;
        while(left<len){
            if(right<len&&nums[right]<nums[left] ){
                minIndex = right;
            }else{
                minIndex = left;
            }

            if(nums[minIndex]>nums[index]){
                minIndex = index;
            }
            if(minIndex == index){
                break;
            }
            swap(nums,minIndex,index);
            index = minIndex;
            left = 2*index+1;
            //woc..........
            right = 2*index+2;
        }

}

    private void swap(int[] nums,int a,int b){
        int temp;
        temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    private void sort(int[] nums){
        int len = nums.length;
        while(len>1){
            swap(nums,0,len-1);
            len--;
            adjustHeap(nums, 0,len);
        }


    }
}
