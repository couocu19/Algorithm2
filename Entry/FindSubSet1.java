package Entry;

import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.ArrayList;
import java.util.List;

public class FindSubSet1 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(find1(nums));

        System.out.println(find2(nums));


    }

    public static List<List<Integer>> find1(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list ;
        int len = nums.length;
        int[] flag = new int[len];
        double num = Math.pow(2,len);
        for(int i =0;i<num;i++){
            //每进行一次循环就要给数组重新赋值
            list = new ArrayList<>();
            flag = binaryToDecimal(i,flag);
             for(int j =0;j<len;j++){
                 if(flag[j] == 1){
                     list.add(nums[j]);
                 }
             }
            result.add(list);
        }
        return result;
    }

    private static int[] binaryToDecimal(int n,int[] flag){
        int len = flag.length;
        int t = 0;
        for(int i = len-1;i>=0;i--){
            flag[t++] = n>> i &1 ;
        }

        return flag;


    }

    public static List<List<Integer>> find2(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(result,nums,list,0);
        return result;

    }

    private static void backtrack(List<List<Integer>> result,int[] nums,List<Integer> list,int begin){

        int len = nums.length;
        result.add(new ArrayList<>(list));
        for(int i =begin;i<len;i++){
            list.add(nums[i]);
            backtrack(result,nums,list,i+1);
            //回溯回溯回溯
            list.remove(list.size()-1);
        }
    }

}
