package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {

    public static void main(String[] args) {
        Solution39s s = new Solution39s();
        int target = 7;
        int nums[] = {2,3,6,7,8};
        System.out.println(s.combinationSum(nums,target));
    }
}
class Solution39s {
    private List<List<Integer>> outputs = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();
    private int len;
    private int sum = 0;
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.len = candidates.length;
        this.candidates = candidates;
        //首先对数组进行排序,保证后续的递归产生的结果集不重复
        Arrays.sort(candidates);
        backTrack(sum,target,0,list);

        return outputs;
    }

    private void backTrack(int sum,int target,int start,List<Integer> list){
        if(sum == target){
            outputs.add(new ArrayList<>(list));
            return;
        }

        //优化代码:改变每次递归回溯体的"起点",前提是数组已经排序
        for(int i = start;i<len;i++){
            if(sum>target) continue;

            sum += candidates[i];
            list.add(candidates[i]);
            backTrack(sum,target,i,list);

            //回溯:状态返回
            list.remove(list.size()-1);
            sum -= candidates[i];
        }
    }
}
