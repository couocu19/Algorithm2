package Entry;

public class SearchRange {
    public static void main(String[] args) {

        Solution34 s = new Solution34();
        int[] nums = {8,5,7,7,10};
        int[] result = s.searchRange(nums,8);
        for(int a:result){
            System.out.println(a);
        }

    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        int len = nums.length;
        for(int i =0;i<len;i++){
            if(target == nums[i]){
                if(start<0) {
                    start = i;
                    end = i;
                }
//                else if(end<0)
//                    end = i;
                else
                    end = i;
            }
        }
//        if(end<0){
//            end = start;
//        }
        int[] result = {start,end};
        return result;

    }
}