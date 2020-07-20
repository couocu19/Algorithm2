package Entry;

public class FindMinK {

    public static void main(String[] args) {
        int[] nums = {6,2,8,1,9,0};
        int k = 3;
        FindMinK f = new FindMinK();
        for(int a:f.getMink(nums,k)){
            System.out.println(a);
        }

    }

    public int[] getMink(int[] nums,int k){
        int[] res = new int[k];
        for(int i =0;i<k;i++){
            res[i] = Integer.MAX_VALUE;
        }

        for(int i =0;i<nums.length;i++){
            if(nums[i]<res[0]) {
                res[0] = nums[i];
                adjustHeap(res,0,k);
            }

        }
        return res;


    }
    private void swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    private void adjustHeap(int[] nums,int index,int size){
        int left = 2*index+1;
        int right = 2*index+2;
        int largerIndex;
        while(left<size){
            if(right<size && nums[left]<nums[right]){
                largerIndex = right;
            }else{
                largerIndex = left;
            }
            if(nums[index]>nums[largerIndex])
                largerIndex = index;
            if(index == largerIndex)
                break;

            swap(index,largerIndex,nums);
            index = largerIndex;
            left = 2*index+1;
            right = 2*index+2;
        }


    }
}
