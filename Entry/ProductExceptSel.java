package Entry;

import java.util.Arrays;

public class ProductExceptSel {
    public static void main(String[] args) {
        int[] nums = {0,4,0,0,0,1,2,3};
        Solutionp p = new Solutionp();
        System.out.println(Arrays.toString(p.productExceptSelf(nums)));


    }
}
class Solutionp {
    public int[] productExceptSelf(int[] nums) {
        int sum = 1;
        int sum1 = 1;
        int sum2 = 0;
        int t = 0;
        //boolean flag = false;
        for(int i =0;i<nums.length;i++){
            sum2+=nums[i];
            if(nums[i]!=0) {
                sum *= nums[i];
            }else{
                sum1 = 0;
                t++;
            }
        }
        if(t>1){
            for(int i =0;i<nums.length;i++){
                nums[i] = 0;
            }
            return nums;
        }
        if(sum2==0 && sum1 ==0){
            return nums;
        }else {
            if (sum1 == 1) {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = sum / nums[i];
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == 0) {
                        nums[i] = sum;
                    } else {
                        nums[i] = 0;
                    }
                }

            }
        }
        return nums;

    }
}

