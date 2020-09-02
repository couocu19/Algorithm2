package sort;

import java.util.Arrays;

public class SubSort {

    public static void main(String[] args) {
        int[] nums = {1,2,4,7,-1,7,16,18,19};
        Solution16_16 s = new Solution16_16();

        int[] res = s.subSort2(nums);

        for(int a:res){
            System.out.println(a);
        }


    }

}

class Solution16_16 {
    public int[] subSort(int[] array) {
        int len = array.length;
        int[] flag = new int[len];
        for(int i =0;i<len;i++){
            flag[i] = array[i];
        }

        int[] result = {-1,-1};
        Arrays.sort(array);
        for(int i =0;i<len;i++){
            if (flag[i]!=array[i]){
                result[0] = i;
                break;
            }
        }
        for(int j =len-1;j>=0;j--){
            if(flag[j]!=array[j]){
                result[1] = j;
                break;
            }
        }
        return result;
    }

    public int[] subSort1(int[] array){
        int len = array.length;
        int i = 0;
        int j = len-1;
        int[] res = {-1,-1};
        while (i<j){
            if(array[i]>array[j]){
                res[0] = i;
                res[1] = j;
                return res;
            }
            if(array[i] == array[j]){
                res[0] = i;
                res[1] = j;
                while (array[i] == array[j]){
                }


            }
            ++i;
            --j;
        }

        return res;

    }

    /**
     * 思路：
     *   对于一个排序数组，应该满足从前到后递增，从后往前递减的规则。
     *   从前往后遍历，每次比较最大值和当前数组值，如果当前值比max大，更新max值。
     *   如果当前值比max小，那就更新需要排序数组的右边界。
     *
     *   从后往前遍历，和从前往后是同样的道理，但是取值正好相反。
     *   每次比较当前值和最小值，如果当前值更小，就跟新min值；
     *   否则，就更新需要重新排序数组的左边界。
     * @param array
     * @return
     */
    public int[] subSort2(int[] array) {
        int len = array.length;
        int max = Integer.MIN_VALUE;
        int min  = Integer.MAX_VALUE;
        int[] res = {-1,-1};
        for(int i =0;i<len;i++){
            if(array[i]<max){
                res[1] = i;
            }else{
                max = array[i];
            }

            if(array[len-1-i]>min){
                res[0] = len-1-i;
            }else{
                min = array[len-i-1];
            }
        }

        return res;



    }
}