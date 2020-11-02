package Entry;

public class MoveZeroes {
    public static void main(String[] args) {


    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        if(nums == null)
            return;

        int len = nums.length;
        int j = 0;
        for(int i =0;i<len;i++){
            if(nums[i]!=0){
                nums[j++] = nums[i];
            }
        }
        for(int i = j;i<len;i++){
            nums[i] = 0;
        }

    }
}
