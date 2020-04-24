package Entry;

public class Search {
    public static void main(String[] args) {
        Solution33 s = new Solution33();
        Solution33s s1 = new Solution33s();
        int nums[] = {3,5,1};
        int target = 4;

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

    private int[] nums;
    private int target;
    public int search(int[] nums, int target){
        this.nums = nums;
        this.target = target;
        int len = nums.length;
        if(len == 0)
            return -1;
        if(len == 1)
            return nums[0]==target?0:-1;
        int low = 0;
        int high = len-1;
        int mid = (low+high)/2;
        if(target == nums[0])
            return 0;
        if(target == nums[high])
            return high;
        if(target == nums[mid])
            return mid;
        int minIndex = minIndex(low,high);
        if(minIndex == 0)
            return tSearch(0,len-1);
        else {
            if (target > nums[0]) {
                //说明在前半部分
                //high = minIndex - 1;
               return tSearch(0,minIndex);
            } else if (target >= nums[minIndex]) {
                //说明在后半部分
               // low = minIndex;
                return tSearch(minIndex,len-1);
            }
        }
        return -1;

    }

    private int minIndex(int low,int high){
        //如果旋转个数为0，即假如没有旋转，单独处理，直接返回数组头元素
        if(nums[low]<nums[high])
            return 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>nums[mid+1])
                return (mid+1);
            if(nums[mid]<nums[mid-1])
                return mid;
            else{
                if(nums[mid]<nums[low])
                    high = mid-1;
                else
                    low = mid+1;
                }
           // }
        }

        return 0;
    }

    private int tSearch(int left,int right){
        while(left<=right){
            //
            // int mid = (right+left)/2;
            //这么写可以防止溢出？
            int mid = left+(right-left)/2;
            if(nums[mid] == target)
                return mid;
            else{
                if(nums[mid]<target)
                    left = mid+1;
                else
                    right = mid-1;
            }
        }
        return -1;
    }
}


class Solution33s {
    int [] nums;
    int target;

    public int find_rotate_index(int left, int right) {
        if (nums[left] < nums[right])
            return 0;

        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1])
                return pivot + 1;
            else {
                if (nums[pivot] < nums[left])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return 0;
    }

    public int search(int left, int right) {
    /*
    Binary search
    */
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target)
                return pivot;
            else {
                if (target < nums[pivot])
                    right = pivot - 1;
                else
                    left = pivot + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length;

        if (n == 0)
            return -1;
        if (n == 1)
            return this.nums[0] == target ? 0 : -1;

        int rotate_index = find_rotate_index(0, n - 1);

        // if target is the smallest element
        if (nums[rotate_index] == target)
            return rotate_index;
        // if array is not rotated, search in the entire array
        if (rotate_index == 0)
            return search(0, n - 1);
        if (target < nums[0])
            // search in the right side
            return search(rotate_index, n - 1);
        // search in the left side
        return search(0, rotate_index);
    }
}

