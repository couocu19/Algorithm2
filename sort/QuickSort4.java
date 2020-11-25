package sort;

public class QuickSort4 {
    public static void main(String[] args) {
        int[] nums = {-3,22,5,11,67,54,63,56};
        qSort(nums,0,nums.length-1);
        for(int num:nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void qSort(int[] nums,int low,int high){
        if(low<high){
            int l = getLocate(nums,low,high);
            qSort(nums,low,l-1);
            qSort(nums,l+1,high);
        }
    }

    public static int getLocate(int[] nums,int low,int high){
        int key = nums[low];
        while(low<high){
            while (low<high && nums[high]>=key)
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
