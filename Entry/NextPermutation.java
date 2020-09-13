package Entry;


/**
 * 怎样获取一个排列的下一个在字典中的排列？
 *    1.从后往前遍历，找到第一个相邻的升序元素，分别用i，j标记
 *    2.这时可以保证j以及j之后的元素一定是降序排列的。
 *    3.从后往前遍历[j,end)中的元素，找到第一个大于i指针对应的元素的值，用指针k对应
 *    4.交换i，k对应的元素
 *    5.对[j,end)中的元素进行翻转，使其变为升序状态
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        Solution31 s = new Solution31();

        s.nextPermutation(nums);

        for(int a:nums){
            System.out.print(a+" ");
        }

        System.out.println();
    }
}


class Solution31 {
    public void nextPermutation(int[] nums) {
        int i,j;
        int len = nums.length;
        i = len-2;
        j = len-1;
        while(i>=0 && j>=0){
            if(nums[i]<nums[j]){
                break;
            }
            i--;
            j--;
        }

        //如果整个数组的排列为降序，将i的值置为0，直接反转整个序列
        if(i<0){
            i = 0;
        }
        System.out.println(i+" "+j);
        for(int k = len-1;k>=j;k--){
            if(nums[k]>nums[i]){
                swap(nums,i,k);
                break;
            }
        }

        reverse(nums,j);



    }

    private void reverse(int[] nums,int j){
        int len = nums.length-1;
        int i = j;
        while(i<len){
            swap(nums,i,len);
            i++;
            len--;
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
class Solution31s {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
