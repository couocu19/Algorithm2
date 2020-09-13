package backtrack;

import java.util.ArrayList;
import java.util.List;

public class PermuteUnique {
    public static void main(String[] args) {
        Solution47 s = new Solution47();
        int nums[] = {1,3,2};
        System.out.println(s.permuteUnique(nums));
        System.out.println(s.permuteUnique(nums).size());

    }

}


class Solution47 {

    private List<List<Integer>> outputs = new ArrayList<>();
    private int len;
    private List<Integer> list = new ArrayList<>();


    public List<List<Integer>> permuteUnique(int[] nums) {
        this.len = nums.length;
        int flag[] = new int[len];

        backTrack(list,nums,flag);
        return outputs;
    }

    private void backTrack(List<Integer> list,int[] nums,int[] flag){

        if(list.size() == len && !outputs.contains(list)){
            outputs.add(new ArrayList<>(list));
            return;
        }

        for(int i =0;i<len;i++){

            if(flag[i] == 1)
               continue;

            flag[i] = 1;
            list.add(nums[i]);
            //进行下一状态
            backTrack(list,nums,flag);
            //回溯的状态返回
            list.remove(list.size()-1);
            flag[i] = 0;

        }


    }
}