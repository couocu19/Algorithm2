package Entry;


/**
 * 给定一个含有重复数字的数组，给定数组中存在的两个值，
 * 找出这两个值在数组中的最短距离。
 *
 */
public class MinDistance {
    public static void main(String[] args) {
        int nums[] = {4,5,6,4,7,4,7,8,5,6,4,3,10};
        int a = 4;
        int b = 7;
        System.out.println(getMin(nums,a,b));

    }


    /**
     * 时间复杂度：O(n)
     * 思路:采用动态规划的思路对数组进行一次遍历
     * @param nums
     * @param a
     * @param b
     * @return
     */
    public static int getMin(int[] nums,int a,int b){
        int minDistance = Integer.MAX_VALUE;
        int lastPost1 = -1;
        int lastPost2 = -1;
        int len = nums.length;
        for(int i =0;i<len;i++){
            if(nums[i] == a){
                lastPost1 = i;
                if(lastPost2>0){
                    minDistance = Math.min(minDistance,lastPost1-lastPost2);

                }
            }

            if(nums[i] == b){
                lastPost2 = i;
                if(lastPost1>0){

                    minDistance = Math.min(minDistance,lastPost2-lastPost1);
                }
            }
        }

        return minDistance;

    }
}
