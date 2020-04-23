package Entry;

public class Search {
    public static void main(String[] args) {
        Solution33 s = new Solution33();
        int nums[] = {3,5,1};
        int target = 3;

       // System.out.println(s.minIndex(nums,0,nums.length-1));
        System.out.println(s.search(nums,target));
    }

}


/**
 * 思路：一个有序数组旋转后将被分为两个有序数组，基本思路就是先确定target
 *      在哪个部分中，然后在对应的部分中进行二分查找。
 *      确定这两个部分的时候也采用二分法+判断来判定
 * 关键：旋转数组的两个特点：
 *      1.旋转后的有序数组将被分为两个有序数组
 *      2.旋转之后的有序数组前半部分的值全部都大于后半部分。
 *        (假设数组没有重复值)
 */
class Solution33 {
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        int len = nums.length;
        int low = 0;
        int high = len-1;
        int mid = (low+high)/2;
        if(target == nums[0]){
            return 0;
        }
        if(target == nums[high]){
            return high;
        }
        if(target == nums[mid]){
            return mid;
        }
        int minIndex = minIndex(nums,low,high);
        //判断目标值在哪个部分
        if(target>nums[0]){
            //说明在前半部分
            high = minIndex-1;
            while(low<=high){
                mid = (low+high)/2;
                if(target ==nums[mid]){
                    return mid;
                }else if(target<nums[mid]){
                    high = mid;
                }else{
                    low = mid+1;
                }
            }
        }else if(target>= nums[minIndex]){
            //说明在后半部分
            low = minIndex;
            while(low<=high){
                mid = (low+high)/2;
                if(target ==nums[mid]){
                    return mid;
                }else if(target<nums[mid]){
                    high = mid;
                }else{
                    low = mid+1;
                }
            }
        }
        return -1;

    }

    public static int minIndex(int[] nums,int low,int high){
        //如果旋转个数为0，即假如没有旋转，单独处理，直接返回数组头元素
        if(high<low)
            return 0;

        //只剩一个元素一定是最小值
        if(high == low){
            return low;
        }
        //mid = (low+high)/2; 采用下面的写法防止溢出
        int mid = low + ((high-low)>>1);
        //判断nums[mid]是否为最小值
        if((mid-1)>0&&nums[mid]<nums[mid-1])
            return mid;
        //判断nums[mid+1]是否为最小值
        else if((mid+1)<nums.length&&nums[mid+1]<nums[mid])
            return (mid+1);

        //最小值一定在数组左半部分
        else if(nums[high]>nums[mid])
            return minIndex(nums,low,mid-1);
        else{
            return minIndex(nums, mid + 1, high);

        }
    }
}
