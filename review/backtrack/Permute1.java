package review.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permute1 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Solution46s s = new Solution46s();
        System.out.println(s.permute(nums));


    }
}

class Solution46s {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private int[] nums;
    private int len;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.len = nums.length;

        backtrack(list);

        return res;

    }
    private void backtrack(List<Integer> list){
        if(list.size() == len){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int a: nums){
            if(!list.contains(a)){
                list.add(a);
                backtrack(list);

                list.remove(list.size()-1);
            }
        }
    }
}