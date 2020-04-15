package Entry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//返回数组中的唯一重复元素
public class FindDup {

    public static void main(String[] args) {
        int[] nums = {4,1,4,4,4,4,6};
        System.out.println(findDup1(nums));
        System.out.println(findDup2(nums));
        System.out.println(findDup3(nums));
        System.out.println(findDup4(nums));
        System.out.println(findDup5(nums));
    }

    public static int findDup1(int[] nums){
        Arrays.sort(nums);
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == nums[i-1])
                return nums[i];
        }
        return 0;
    }

    public static int findDup2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int a:nums){
            if(set.contains(a)){
                return a;
            }
            set.add(a);
        }
        return 0;
    }

    //二分法＋循环
    public static int findDup3(int[] nums){
        int len = nums.length;
        int left = 0;
        int right = len-1;
        int mid = 0;
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


    //最简单的方法
    //累加求和法
    public static int findDup4(int[] nums){
        int len = nums.length;
        int sum = len*(len-1)/2;
        int sum1 = 0;
        for(int a:nums){
            sum1+=a;
        }
        return (sum1-sum);
    }


    //数据下标映射法
    public static int findDup5(int[] nums){
        int index = 0;
        while(true){
            nums[index] = -1*nums[index];
            index = -1*nums[index];

            if(index>=nums.length){
                System.out.println("数组中含有非法数据");
                return -1;
            }
            if(nums[index]<0){
                break;
            }

        }

        return (-1*nums[index]);

    }



}
