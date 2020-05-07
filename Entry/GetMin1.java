package Entry;

public class GetMin1 {
    public static void main(String[] args) {

        int nums[] = {1,3,5,9,7,11};
        System.out.println(getMid(nums));

    }

    public static int getMid(int[] nums){
        int low = 0;
        int high = nums.length-1;
        int mid = (low+high)/2;
        int pos;
        while(true){
             pos = partition(nums,low,high);
            if(pos == mid)
                break;
            else if(pos>mid)
                high = pos-1;
            else
                low = pos+1;
        }
        //如果数组长度为奇数,就直接返回中位数
        if(nums.length%2 == 1)
            return nums[pos];
        //如果数组长度为偶数,需要在找到第二个中位数，则在之后的数中找到最小值
        //并和第一个中位数求平均值
        else{
            int min = getMin(nums,pos+1,nums.length-1);
            return (nums[pos]+min)/2;
        }
    }

    public static int getMin(int[] nums,int start,int end) {
        int len = end - start + 1;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] < min)
                min = nums[i];
        }
        return min;
    }

    public static int partition(int[] nums,int low,int high){
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
