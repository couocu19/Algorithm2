package review.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {



    }
}


class Solution78{

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        backtrack(nums,list,0);

        return result;
    }

    private void backtrack(int[] nums,List<Integer> list,int start){
        result.add(new ArrayList<>(list));

        for(int i =start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,list,i+1);
            list.remove(list.size()-1);

        }
    }

}