package Entry;

public class RemoveDuplicatesPlus {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        Solutiong d = new Solutiong();
        System.out.println(d.removeDuplicates(nums));

    }
}
class Solutiong {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        if(nums.length<=2)
            return nums.length;
        for(int j = 1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                if((i+2)<nums.length) {
                    i += 2;
                    nums[i] = nums[j];
                }else{
                    i++;
                }
            }

        }
        return  i+1;



    }
}


