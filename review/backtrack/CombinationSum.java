package review.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {


    }
}

class Solution39 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        back(list,0,target,0,candidates);
        return res;
    }

    private void back(List<Integer> list,int start,int target,int sum,int[] can){
        if(sum == target){
            res.add(new ArrayList<>(list));
        }else {
            for (int i = start; i < can.length; i++) {
                if (sum > target)
                    continue;
                list.add(can[i]);
                sum += can[i];

                back(list, i, target, sum, can);
                sum -= can[i];
                list.remove(list.size() - 1);
            }
        }


    }
}
