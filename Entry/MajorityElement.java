package Entry;

import java.util.Arrays;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        Solution169 s = new Solution169();
        System.out.println(s.majorityElement(nums));


    }
}


class Solution169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int count = 1;
        int res = Integer.MIN_VALUE;
        for(int i =1;i<len;i++){
            if(nums[i]!=nums[i-1]){
                if(count>len/2){
                    System.out.println("ok");
                    res = nums[i-1];
                    break;
                }else{
                    count = 1;
                }
            }
            count++;
        }

        if(res == -1)
            res = nums[len-1];

        return res;


    }

    //投票法计算
    public int majorityElement1(int[] nums) {
        int len = nums.length;
        int count = 1;
        int res = nums[0];
        for(int i =1;i<len;i++){
            if(nums[i] == res){
                count++;
            }else if(--count == 0){
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }
}