package Entry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//求某一个数组的所有子集
public class AllSubset {
    public  List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        AllSubset s = new AllSubset();

        System.out.println(s.findSub(nums));


    }


    public List<List<Integer>> findSub(int[] nums){
        int[] flag = new int[nums.length];
        List<Integer> list = new ArrayList<>();
        backtrack(nums,list,flag);

        return result;


    }

    private void backtrack(int[] nums,List<Integer> list,int[] flags){
            int len = nums.length;
            for(int i =0;i<nums.length;i++){
                if(!list.contains(nums[i])) {
                    list.add(nums[i]);

                    List<Integer> l = new ArrayList<>(list);
                    Collections.sort(l);
                    if(!result.contains(l)) {
                        result.add(new ArrayList<>(l));
                    }
                    backtrack(nums,list,flags);
                    list.remove(list.size()-1);
                }
            }


    }









}
