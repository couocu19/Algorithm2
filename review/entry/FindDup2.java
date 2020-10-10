package review.entry;

public class FindDup2 {
    public static void main(String[] args) {

        int[] nums = {2,3,3,4,6,5,1};
        System.out.println(getDup1(nums));
        System.out.println(getDup2(nums));


    }


    public static int getDup(int[] nums){
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow!=fast);

        slow = 0;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }



    public static int getDup1(int[] nums){
        int slow = 0;
        int fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow!=fast);

        slow = 0;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }


    public static int getDup2(int[] nums){
        int len = nums.length;
        int low = 0;
        int high = len-1;
        int mid;


        int t;
        while (low<high){
            mid = (low+high)/2;
            t = 0;
            for(int i =0;i<len;i++){
                if(nums[i]<=mid){
                  t++;
                }
            }
            if(t>mid){
                high = mid;
            }else{
                low = mid+1;

            }
        }

        return low;




    }


}
