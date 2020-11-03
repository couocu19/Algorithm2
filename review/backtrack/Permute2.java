package review.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permute2 {
    public static void main(String[] args) {


    }
}


class Solution46ss {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backtrack(list,nums);

        return res;
    }

    private void backtrack(List<Integer> list,int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int a:nums){
            if(!list.contains(a)){
                list.add(a);
                backtrack(list,nums);

                list.remove(list.size()-1);
            }
        }

    }
}