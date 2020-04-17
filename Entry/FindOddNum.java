package Entry;

import java.util.ArrayList;
import java.util.List;

/**
 * 找出数组中出现次数为奇数的数字
 * 前提：出现次数为奇数的数有两个
 */

public class FindOddNum {
    public static void main(String[] args) {

        int nums[] = {1,1,3,2,2,3,5,5,4,6,7,6};
        System.out.println(find(nums));
    }


    /**
     * 解题思路：
     * 根据异或的运算性质：每个数和他本身进行异或运算，结果都为0；
     *                  每个数和0进行异或运算，结果都为它本身。
     * 根据题意，数组中所有出现偶数次的数异或之后都会抵消成0，
     * 最后剩下的结果即为出现次数为奇数的两个数的异或结果。
     * @param nums
     * @return
     */
    public static List<Integer> find(int[] nums){
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        int result = 0;
        for(int i =0;i<len;i++){
            result = result^nums[i];
        }
        //临时保存异或结果
        int tempResult = result;
        int position = 0;
        //找出异或结果中其中一个位值为1的位数
        //每次将result右移一位，将当前最低位与1进行与运算，如果结果为1
        //说明该位的数为1，并记录这个所在的位数
        for(int i =result;(i&1) == 0;i = i>>1){
            position++;
        }
        for(int i =0;i<len;i++){

            if(((nums[i]>>position)&1) == 1){
                result = result^nums[i];
            }
        }
        list.add(result);
        list.add(result^tempResult);

        return list;
    }

}
