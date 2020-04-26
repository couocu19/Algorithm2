package Entry;

public class MaxSubArray {
    public static void main(String[] args) {
        int nums[] = {1,-2,4,8,-4,7,-1,-5};
        System.out.println(getMax(nums));
        System.out.println(getMax1(nums));



    }

    //方法一：两次遍历数组，每次求和保存子数组的和，并和最大的和进行比较
    public static int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int len = nums.length;
        for(int i =0;i<len;i++){
            sum = 0;
            for(int j =i;j<len;j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * 方法二：将最小子数组和分为三种情况来讨论。
     * 分析：最下子数组和只可能分为三总情况:
     *      1.数组的最后一个元素本身为最大子数组。
     *      2.数组的最大子数组包含最后一个元素的值。
     *      3.数组的最大子数组不包含最后一个元素的值，即为数组[1~(n-2)]的最大子数组
     * 思路：动态规划，每遍历一次数组就比较这三个值。比较出这三个值中最大的一个值
     * 时间复杂度：O(n)
     * @param nums
     * @return
     */
    public static int getMax1(int[] nums){
        int endMax = nums[0];
        int result = nums[0];
        int len = nums.length;

        for(int i =1;i<len;i++){
            endMax = Integer.max(endMax+nums[i],nums[i]);
            result = Integer.max(endMax,result);
        }
        return result;

    }
}
