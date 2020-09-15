package Entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        int[] nums = {-3,-2,-1,0,0,1,2,3};
        int target = 0;
        Solution18 s = new Solution18();
        System.out.println(s.fourSum(nums,target));


    }
}

class Solution18 {
    private List<Integer> list = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    private int target;

    private int sum;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        this.target = target;
        int len = nums.length;
        if(len == 0)
            return res;
        Arrays.sort(nums);
        int i =0;
        int j =len-1;
        int m = -1 ;
        int n = -1;
         getList(i,j,nums);
        while(i<j){
//            if(sum == target){
//                //i++;
//                //j--;
//                getList(i,j++,nums);
//                getList(i++,j,nums);
//                getList(i,j,nums);
//            }else {
            System.out.println(nums[i+1]+" "+nums[j]);
            getList(i++,j,nums);
          //  System.out.println(res);


            i--;
            getList(i,j--,nums);

            getList(i++,j,nums);
           // System.out.println(i+" "+j);
                //getList(i,j--,nums);
//            }
        }
//        i = 1;
//        j = len-2;
//        while(i<j){
//            getList(i,j--,nums);
//            System.out.println(j);
//        }
        return res;
    }
    private void getList(int i,int j,int[] nums){
       // int sum = 0;
        int m = i+1;
        int n = j-1;
            while(m<n) {
                if(nums[m] == nums[m-1] || nums[n] == nums[n+1]){
                    continue;
                }
                sum = nums[i] + nums[j] + nums[m] + nums[n];
                if (sum == target) {
                    System.out.println(nums[i]+" "+nums[j]+" "+nums[m]+" " +nums[n]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[m]);
                    list.add(nums[n]);
                    if(!res.contains(list)) {
                        res.add(list);
                    }
                    list = new ArrayList<>();
                    m++;
                    n--;
                } else if (sum > target) {
                    n--;
                }else{
                    m++;
                }
            }
           // return sum;
    }
}
