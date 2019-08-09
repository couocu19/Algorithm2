package tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//39 组合总和
public class Combination {
    public static void main(String[] args) {

    }
}

class Solution39 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length<1 || target < 0){
            return result;
        }
        //排序
        Arrays.sort(candidates);
        find(candidates,target,0,new ArrayList<>());
        return result;
    }


    //从candidates的索引为index位之后查找和为target的组合
    private void find(int[] candidates,int target,int index,List<Integer> temp){
        if(target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i =index;i<candidates.length && candidates[i] <= target;i++){
            temp.add(candidates[i]);
            find(candidates,target - candidates[i],i,temp);
            //如果没有结果就从temp中移除
            temp.remove(temp.size() - 1);

        }
    }
}