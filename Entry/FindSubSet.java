package Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//寻找数组的所有子集
//方法:定位法
public class FindSubSet {

    public static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] flag = new int[nums.length];
        System.out.println(find(nums,flag));

    }

    public static List<List<Integer>> find(int[] nums,int[] flag){
        List<Integer> list = new ArrayList<>();
        double len = Math.pow(2,nums.length);
        for(int i =0;i<len;i++){
            flag = binaryToDecimal(i,flag,flag.length);
            for(int j = 0;j<flag.length;j++){
                if(flag[j] == 1){
                    list.add(nums[j]);
                }
            }
            result.add(list);
            list = new ArrayList<>();
        }
        return result;

    }

    //将十进制数转为二进制数
    public static int[] binaryToDecimal(int n,int[] flags,int len){
        int t = 0;
        for(int i = len-1;i >= 0; i--) {
            flags[t++] = n >> i & 1;
        }

        return flags;
    }


}
