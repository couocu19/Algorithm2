package sort;

public class HeapSort4 {
    public static void main(String[] args) {
        int[] nums = {4,3,6,77,-1,24,7};
        heapSort h = new heapSort();
        nums = h.sorts(nums);

        for(int a:nums){
            System.out.print(a+" ");
        }

        System.out.println();




    }

}

class heapSort{
    public int[] sorts(int[] nums){
        heapConstructor(nums);

        int size = nums.length;
        //todo:注意
        while(size>1){
            swap(nums,0,size-1);
            size--;
            heapfiy(nums,size,0);
        }
        return nums;
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    private void heapConstructor(int[] nums){
        int len = nums.length;
        for(int i =0;i<len;i++){
            int current = i;
            int farther = (current-1)/2;
            while (nums[current]>nums[farther]){
                swap(nums,current,farther);
                current = farther;
                farther = (current-1)/2;
            }

        }
    }


    private void heapfiy(int[] nums,int size,int index){
        int left = 2*index+1;
        int right = 2*index+2;

        int largerIndex;
        while (left<size){
            if(nums[left]<nums[right]&&right<size ){
                largerIndex = right;
            }else{
                largerIndex = left;
            }

            if(nums[largerIndex]<nums[index]){
                largerIndex = index;
            }

            if(index == largerIndex){
                break;
            }

            swap(nums,largerIndex,index);
            index = largerIndex;
            left = 2*index+1;
            right = 2*index+2;
        }

    }





}
