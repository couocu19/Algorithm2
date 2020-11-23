package sort;

public class QuickSort3 {
    public static void main(String[] args) {
        int[] nums = {3,4,2,3,1,1,99,-6,4};
        qSort(nums,0,nums.length-1);
        for(int a:nums){

            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void qSort(int[] nums,int low ,int high){
        if(low<high){
            int p = locate(nums,low,high);
            qSort(nums,low,p-1);
            qSort(nums,p+1,high);
        }
    }

    public static int locate(int[] nums,int low,int high){
        int key = nums[low];
        while(low<high){
            while(low<high &&nums[high]>=key)
                high--;
            nums[low] = nums[high];

            while(low<high && nums[low] <= key)
                 low++;
            nums[high] = nums[low];
        }
        nums[low] = key;

        return low;

    }
}


