package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution39 s = new Solution39();
        int target = 7;
        int nums[] = {2,3,6,7};
        System.out.println(s.combinationSum(nums,target));

    }
}

class Solution39 {
    private List<List<Integer>> outputs = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private int len;
    private int sum = 0;
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.len = candidates.length;
        this.candidates = candidates;

        backTrack(sum,target,list);

        return outputs;
    }

    private void backTrack(int sum,int target,List<Integer> list){
        if(sum == target){
            Integer init[] = list.toArray(new Integer[0]);
            Arrays.sort(init);
            list = new ArrayList(Arrays.asList(init));
            if(!outputs.contains(list)) {
                // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
                outputs.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i =0;i<len;i++){
            if(sum>target) continue;

            sum += candidates[i];

            list.add(candidates[i]);


            backTrack(sum,target,list);

            //回溯:状态返回
            list.remove(list.size()-1);
            sum -= candidates[i];
        }





    }
}
