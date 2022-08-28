package top100;

public class No26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,2,3,3,4};
        Solution26 s = new Solution26();
        System.out.println(s.removeDuplicates(nums));

    }
}


class Solution26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1)
            return len;

        int i ;
        int j ;
        for(i = 0,j = 1;j<len;){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }else{
                j++;
            }
        }
//        for(int k = 0;k<len;k++){
//            System.out.print(nums[k]+" ");
//        }
//        System.out.println();
        return (i+1);
    }
}