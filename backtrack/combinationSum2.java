package backtrack;

import java.util.ArrayList;
import java.util.List;

public class combinationSum2 {

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        Solution39s1 s = new Solution39s1();
        System.out.println(s.combinationSum(nums,7));

    }

}

class Solution39s1{
    private List<List<Integer>> result = new ArrayList<>();
    private int[] candidates;
    private int target;
    private int len;
    private int sum = 0;



    public List<List<Integer>> combinationSum(int[] candidates, int target){
        this.candidates = candidates;
        this.target = target;
        this.len = candidates.length;


        List<Integer> list = new ArrayList<>();
        backtrack(list,0,sum);

        return result;


    }

    private void backtrack(List<Integer> list,int start,int sum){

        if(sum == target){
//            System.out.println(sum);
//            System.out.println(list);
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i =start;i<len;i++){
            if(sum>target) continue;

            sum+=candidates[i];
            list.add(candidates[i]);
            //回溯主体
            backtrack(list,i,sum);

            //状态返回
            list.remove(list.size()-1);
            sum-=candidates[i];

        }

    }




}
