package Entry;


public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        Solution a = new Solution();
        System.out.println(a.searchInsert(nums,target));

    }

}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int location = 0;
        int i;
        for(i = 0;i<nums.length;i++) {
            if (target == nums[i]) {
                location = i;
                break;
              // return i;
            }
        }
        if(i==nums.length){
            if(target<nums[0])
                return 0;
            else if(target>nums[nums.length-1]){
                return nums.length;

            }
            else{
                  for(int j =1;j<nums.length;j++){
                      if(target<nums[j] && target>nums[j-1]){
                          return j;
                      }
                  }

            }
        }
        return location;
    }
}