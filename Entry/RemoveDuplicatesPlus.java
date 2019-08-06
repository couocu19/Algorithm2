package Entry;

import java.util.Arrays;

public class RemoveDuplicatesPlus {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3};
        Solutiong d = new Solutiong();
        System.out.println(d.removeDuplicates(nums));

    }
}
class Solutiong {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j;
        int len = nums.length;
        if(nums.length<=2)
            return nums.length;
        for(j = 1;j<len-1;++j){
            if(nums[j] != nums[i]){
                if(j-i<=2){
                    i+=(j-i);
                } else if(j-i>2){
                    System.out.println("1");
                    i+=2;
                    int flag = j;
                    int k;
                    for(k = i;k<(i+len-j);k++){
                        nums[k] = nums[flag++];
                    }
                    len = k;
                    j = i;
                }
            }
        }
        if(nums[len-1] ==nums[len-2]){
            return (i+2);
        }else {
            if(nums[len-1] != nums[i]){
                if(((len-1)-i)>2){
                    i+=2;
                    nums[i] = nums[len-1];
                    return i+1;
                }else{
                    return len;
                }

            }
            return len;
        }

    }
}


