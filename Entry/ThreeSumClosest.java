package Entry;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1,2,0,-4};
        int tar = 1;
        Solution16 s = new Solution16();
        System.out.println(s.threeSumClosest(nums,tar));


    }

}

/**
 *
 * 方法：首先将数组进行排序，然后定一个点并且使用双指针来确定。
 */
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int start;
        int end;
        int sum;
        int dValue;
        int minD = Integer.MAX_VALUE;
        int minSum = 0;
        for(int i =0;i<len;i++){
            start = i+1;
            end = len-1;
            while(start<end) {

                sum = nums[start] + nums[end] + nums[i];
//                System.out.println(sum);
                dValue = Math.abs(sum - target);
                if (dValue < minD) {
                    minD = dValue;
                    minSum = sum;
                }
                if (sum > target) {
//                    System.out.println(">");
                    end--;
                } else if (sum < target) {
//                    System.out.println("<");
                    start++;
                } else {
                    return sum;
                }
            }
        }

        return minSum;


    }
}