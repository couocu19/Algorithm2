package sort;

public class QuickSort1 {

    public static void main(String[] args) {

        QuickSort1 q = new QuickSort1();
        int[] nums = {-2,-1,1,3,-7,-6,-8};
        q.quick(nums,0,nums.length-1);

        for(int a:nums){
            System.out.print(a+" ");
        }
        System.out.println();



    }


    public  void quick(int[] nums,int low,int high){

        int len = nums.length;

        if(low<high) {
            int pos = getPos(nums, low, high);
            quick(nums, low, pos - 1);
            quick(nums, pos + 1, high);
        }

    }

    private int getPos(int[] nums,int low,int high){
        int key = nums[low];
        while(low<high){
            while (low<high && nums[high]>=key)
                high--;
            nums[low] = nums[high];
            while (low<high &&nums[low]<=key)
                low++;
            nums[high] = nums[low];
        }
        nums[low] = key;

        return low;
    }


}
