package Entry;

public class Exchange {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Solution21 s = new Solution21();
        int[] res = s.exchange(nums);
        for(int a:res){
            System.out.print(a+" ");
        }
        System.out.println();


    }
}


class Solution21 {
    public int[] exchange(int[] nums) {
        if(nums == null)
            return null;
        int len = nums.length;
        int[] res = new int[len];
        int i =0;
        int j = len-1;
        for(int k = 0;k<len;k++){
            if(nums[k]%2 == 0){
                res[j--] = nums[k];
            }else{
                res[i++] = nums[k];
            }
        }
        return res;
    }

    public int[] exchange1(int[] nums) {
        int p = 0;
        int len = nums.length;
        for(int i =0;i<len;i++){
            if((nums[i]&1) == 1){
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p++] = tmp;
            }
        }

        return nums;

    }
}

