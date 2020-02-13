package backtrack;

import java.util.ArrayList;
import java.util.List;

//全排列
public class Permute {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        Solution46 s = new Solution46();
        System.out.println(s.permute(nums));
    }

}

class Solution46 {

    private List<List<Integer>> outputs = new ArrayList<>();
    private int len;
    private List<Integer> list1 = new ArrayList<>();


    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        backTrack(list1,nums);
        return outputs;

    }

    private void backTrack(List<Integer> list,int[] nums) {
        //回溯终止条件
        //向结果集中添加list时，不能直接将list加入，
        // 应该new一个新的list并将list的内容拷贝进去
        if (list.size() == len) {
            outputs.add(new ArrayList<>(list));
            return;
        } else {
            for(int a:nums){
                if(!list.contains(a)){
                    list.add(a);
                    backTrack(list,nums);
                    //关键 //若不写这一句只能出来一个结果
                    //回溯(状态返回)
                    list.remove(list.size()-1);
                }
            }

        }
    }

}



