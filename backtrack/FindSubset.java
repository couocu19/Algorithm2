package backtrack;

import java.util.ArrayList;
import java.util.List;

public class FindSubset {
    public static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(find(nums));
    }

    public static List<List<Integer>> find(int[] nums){
        List<Integer> list = new ArrayList<>();
        backtrack(nums,list,0);
        return result;
    }

    private static void backtrack(int[] nums,List<Integer> list,int begin){
        result.add(new ArrayList<>(list));
        for(int i =begin;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,list,i+1);
            list.remove(list.size()-1);
        }

    }
}
