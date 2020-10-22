package Entry;

import java.util.Arrays;

public class Three {

    public static void main(String[] args) {

        int[] nums = {4,2,3,2};
        Three t = new Three();
        System.out.println(t.get3(nums));

    }


    public int get(int[] nums){
        int len = nums.length;
        if(len<3)
            return 0;
        Arrays.sort(nums);
        int count = 0;
        for(int i =0;i<len;i++){
            for(int j = i+1;j<len;j++){
                for(int k = j+1;k<len;k++){
                    if(isTrue(nums[i],nums[j],nums[k])){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isTrue(int a,int b,int c){
        if(a == 0 || b == 0 || c == 0)
            return false;
        if(a+b>c)
            return true;

        return false;
    }


    public int get1(int[] nums){
        int len = nums.length;
        if(len<3)
            return 0;
        Arrays.sort(nums);
        if(len == 3){
            if(isTrue(nums[0],nums[1],nums[2]))
                return 1;
            return 0;
        }

        int count = 0;
        for(int i =0;i<len;i++){
            for(int j = i+1;j<len-1;j++){
                for(int k = len-1;k>j;k--){
                    if(isTrue(nums[i],nums[j],nums[k])){
                        count+=(k-j);
                        break;
                    }
                }
            }
        }
        return count;
    }

    public int get2(int[] nums){
        int len = nums.length;

        if(len<3)
            return 0;

        Arrays.sort(nums);
        int l;
        int r;
        int count = 0;
        for(int i = 0;i<len-2;i++){
            l = i+1;
            r = len-1;
            while (l<r){
                if(nums[i]+nums[l]<=nums[r]){
                    l++;
                }

                else {
                    count+=(r-l);
                    break;
                }
            }
        }

        return count;



    }

    public int get3(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;

        int count = 0;
        for(int i =len-1;i>1;i--){
            int r = i-1;
            int l = 0;
            while (l < r) {
                if (nums[l] + nums[r] <= nums[i]) {
                    l++;
                } else {
                    count += (r - l);
                    r--;
                }
            }
        }
        return count;
    }
}
