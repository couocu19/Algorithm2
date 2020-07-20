package Entry;

public class FindTopK {

    public static void main(String[] args) {
        int[] nums = {6,2,8,1,9,0};
        int k = 3;

        FindTopK f = new FindTopK();
        for(int a:f.find(nums,k)){
            System.out.println(a);
        }


    }

    public int[] find(int[] nums,int k){
        int[] result = new int[k];
        for(int i =0;i<k;i++){
            result[i] = Integer.MAX_VALUE;
        }

        for(int i =0;i<nums.length;i++){
            if(nums[i]<result[0]){
                result[0] = nums[i];
//                System.out.println("ok");
//                System.out.println(result[0]);
                 adjustHeap(result,0,k);
            }
            //System.out.println(nums[0]);
        }

        return result;

    }

    private void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }
    private void adjustHeap(int[] nums,int index,int size){
        int left = 2*index +1;
        int right = 2*index +2;
        int largerIndex ;
        while(left<size) {

            if (nums[left] < nums[right] && right<size) {
                largerIndex = right;
            } else {
                largerIndex = left;
            }

            if(nums[index]> nums[largerIndex]){
                largerIndex = index;
            }
            if(index == largerIndex)
                break;
            swap(index,largerIndex,nums);
            index = largerIndex;
            left = 2*index+1;
            right = 2*index+2;
        }
    }



}
