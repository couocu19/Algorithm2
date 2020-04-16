package sort;

public class HeapSort3 {
    public static void main(String[] args) {
        int nums[] = {2,1,3,4,66,7,6,9,88};
        sort(nums);

       // nums =  heapConstructor(nums);
        for(int a:nums){
            System.out.print(a+" ");
        }

    }


    public static void sort(int[] nums){
        nums = heapConstructor(nums);
        int size = nums.length;
        while(size>1){
            swap(nums,0,size-1);
            adjustHeap(nums,0,size-1);
            size--;
        }
    }

    public static int[] heapConstructor(int[] nums){
        int curIndex;
        int fatherIndex;
        int len = nums.length;
        for(int i =0;i<len;i++){
            curIndex = i;
            fatherIndex = (i-1)/2;
            while (nums[curIndex]>nums[fatherIndex]){
                swap(nums,curIndex,fatherIndex);
                curIndex = fatherIndex;
                fatherIndex = (curIndex-1)/2;
            }
        }
        return nums;

    }

    public static void adjustHeap(int[] nums,int index,int size){
        int left = 2*index+1;
        int right = 2*index+2;
        int largeIndex;
        while(left<size){
            if(nums[left]<nums[right] && right<size){
                largeIndex = right;
            }else{
                largeIndex = left;
            }

            if(nums[index]>nums[largeIndex]){
                largeIndex = index;
            }
            if(largeIndex == index){
                break;
            }
            swap(nums,index,largeIndex);
            //每次都要更新左孩子和右孩子的下标值
            index = largeIndex;
            left = 2*index+1;
            right = 2*index+2;

        }
    }




    public static void swap(int[] arr,int a,int b){
        int temp;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
