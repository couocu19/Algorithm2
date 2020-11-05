package review.entry;

public class Exchange {
    public static void main(String[] args) {



    }
}



class Solutionn {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int p = 0;
        for(int i =0;i<len;i++){
            if((nums[i]&1) == 1){
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p++]= tmp;
            }
        }
        return nums;
    }
}
