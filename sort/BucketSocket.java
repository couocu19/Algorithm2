package sort;

public class BucketSocket {
    public static void main(String[] args) {

        int[] nums = {4,3,5,5,3,8,199,3433,199,8,5,1,6,77};
        nums = bucketSort(nums);

        for(int a:nums){
            System.out.print(a+"  ");
        }
        System.out.println();


    }


    //桶排序
    //缺陷：桶排序适用于数组中的数字比较小，数值比较集中的情况，当数组中的数值域分布不均匀时，需要申请很大的数组空间。
    //     桶排序不适用于数组中有负数的情况，因为数组不能作为数组的下标
    public static int[] bucketSort(int[] nums){
        int len = nums.length;
        int[] flag = new int[50000];
        for(int i =0;i<flag.length;i++){
            flag[i] = 0;
        }

        for(int i =0;i<len;i++){
            flag[nums[i]]++;
        }
        int t = 0;
        for(int i =0;i<50000;i++){
            while (flag[i]!=0){
                nums[t++] = i;
                flag[i]--;
            }
        }
        return nums;
    }
}
