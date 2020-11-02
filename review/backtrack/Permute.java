package review.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        int[] nums = {3,3,0,3};
        Solution46 s = new Solution46();
        System.out.println(s.permuteUnique(nums));
    }


}

class Solution46 {

    private boolean[] flag;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        //首先要对数组排序
        Arrays.sort(nums);
        flag = new boolean[nums.length];
        backtrack(list,res, nums,0);
        return res;
    }

    private void backtrack(List<Integer> list,List<List<Integer>> res, int[] nums,int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {

            //需要保证相同的数组都相邻，每次填入的数一定是这个数所在重复数集合中从左往右第一个未被填过的数字
            //如果前一个元素没有使用过，那么当前重复元素下一层的可选项中一定会存在，即一定会重复，会出现 3 X = X 3’
            //即剪枝的条件为：  和前一个元素值相同，并且前一个元素还没有被使用过
            if (flag[i] ||(i>0 && nums[i] == nums[i-1] && !flag[i-1]))
                continue;

            list.add(nums[i]);
            flag[i] = true;

            backtrack(list, res,nums,idx+1);
            flag[i] = false;

            list.remove(idx);

        }
    }
}