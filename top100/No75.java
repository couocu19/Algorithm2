package top100;

public class No75 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,0,1,1,2,0,0,0,1,0};
        Solution75 s = new Solution75();
        s.sortColors(nums);
        for(int a:nums){
            System.out.print(a +" ");
        }


    }
}

class Solution75 {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int ptr = 0;
        for(int i = 0;i<len;i++){
            if(nums[i] == 0){
                swap(nums,i,ptr);
                ptr++;
            }
        }
        for(int i = ptr;i<len;i++){
            if(nums[i] == 1){
                swap(nums,i,ptr);
                ptr++;
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}