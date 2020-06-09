package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int[] nums = {4,4,4,1,4};
        Solution78 s = new Solution78();
        System.out.println(s.subsetsWithDup(nums));

    }
}

class Solution78 {

    private List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        backtrack(list,0,nums);

        return result;


    }

    private void backtrack(List<Integer> list,int start,int[] nums){

//        if(!result.contains(list)) {
            result.add(new ArrayList<>(list));

//        }
        for(int i =start;i<nums.length;i++){

            //若出现重复元素且重复元素不是第一个数组元素时，跳过此循环
            if(i>start && nums[i] == nums[i-1]){
                continue;
            }
                list.add(nums[i]);


            //这里回朔需要的是（i+1）
            backtrack(list,i+1,nums);
            list.remove(list.size()-1);

        }

    }
}
