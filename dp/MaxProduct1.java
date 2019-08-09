package dp;


//152.乘积最大子序列
public class MaxProduct1 {
    public static void main(String[] args) {

    }

}

//动态规划

class SolutionPldp{
    public int maxProduct(int[] nums) {
        int max = Integer.MAX_VALUE;
        int imax = 1;
        int imin = 1;
        for(int i =0;i<nums.length;i++){
            if(nums[i]<0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax,imax*nums[i]);
            imin = Math.min(imin,imin*nums[i]);
            max = Math.max(imax,imin);
        }

        return max;






    }



}

