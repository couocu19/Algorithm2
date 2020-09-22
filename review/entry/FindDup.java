package review.entry;

public class FindDup {
    public static void main(String[] args) {
        int[] nums = {3,3,1,2,5,3,2};
        System.out.println(getDup4(nums));




    }

    /**
     * 解题思路：
     *    根据限制条件：数组中的值都在0~n-1范围内的条件，
     *    可以知道，如果数组中没有重复元素，数组排序之后的下标以及下标对应的值将是相同的，即一个下标对应一个值。
     *    如果有重复的值出现，同一个值将对应两个下标。
     *
     *该方法有什么限制？
     *    该方法的时间复杂度为O(n),但是该方法修改了原数组。
     * @param nums
     * @return
     */
    public static int getDup(int[] nums){
        int len = nums.length;
        int m = -1;
        int temp;
        for(int i =0;i<len;i++){
            if(nums[i]!=i){
              m = nums[nums[i]];
              if(m == nums[i]){
                  return m;
              }else{
                  temp = nums[nums[i]];
                  nums[nums[i]] = nums[i];
                  nums[i] = temp;
              }
            }
        }

        return m;
    }

    //不修改原数组的条件下找到重复元素
    //方法：二分法＋循环
    public static int getDup2(int[] nums){
        int len = nums.length;
        int left = 1;
        int right = len-1;

        int mid;
        int cnt = 0;
        while(left<right){
            mid = (left+right)/2;
            cnt = 0;
            for(int a:nums){
                if(a<=mid){
                    cnt++;
                }
            }

            if(cnt>mid){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;




    }


    public static int getDup3(int[] nums){

        int len = nums.length;
        int left = 1;
        int right = len-1;
        int cnt;
        int mid;
        while(left<right){
            mid = (left+right)/2;
            cnt = 0;
            for(int num:nums){
                if(num<=mid){
                    cnt++;
                }
            }

            if(cnt>mid){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        return left;

    }


    //时间复杂度O(n)
    //空间复杂度O(1)
    public static int getDup4(int[] nums){
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        System.out.println(fast);
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];

            System.out.println(slow+" "+fast);
        }


        return slow;
    }



}
