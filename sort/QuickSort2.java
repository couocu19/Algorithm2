package sort;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] nums = {3,4,2,3,1,1,99,-6,4};
        quick(nums,0,nums.length-1);
        for(int a:nums){

            System.out.print(a+" ");
        }
        System.out.println();

    }


    public static void quick(int[] nums,int low,int high){
        if(low<high){
            int pos = getPos(nums,low,high);
            quick(nums,low,pos-1);
            quick(nums,pos+1,high);

        }
    }


    public static int getPos(int[] nums,int low,int high){
        int key = nums[low];

        while (low<high){
            while(low<high && nums[high]>=key)
                high--;
            nums[low] = high;

            while (low<high && nums[low]<=key)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = key;

        return low;

    }


}
