package Entry;

public class SameThreePart {
    public static void main(String[] args) {

        int[] nums = {3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(findSamePart(nums));

    }

    public static boolean findSamePart(int[] nums){
        int len = nums.length;
        int s1 ;
        int s2 ;
        int s3 ;

        for(int i =0;i<len;i++){
            s1 = getSum(nums,0,i);
            for(int j =(i+1);j<len;j++){
                s2 = getSum(nums,i+1,j);
                s3 = getSum(nums,j+1,len-1);
               if(s1 == s2 && s1 == s3 && s2 == s3){
                   System.out.println(s1);
                   return true;
               }

            }
        }
        return false;


    }

    public static int getSum(int[] nums,int start,int end){
        int sum = 0;
        for(int i =start;i<=end;i++){
            sum+=nums[i];
        }

        return sum;
    }
}
