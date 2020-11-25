package sort;

public class MergeSort1 {
    public static void main(String[] args) {
        int[] nums = {-3,22,5,11,67,54,63,56};
        int[] tmp = new int[nums.length];
        mergeSort(nums,tmp,0,nums.length-1);

        for(int num:nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] nums,int[] tmp,int low,int high){
        if(low<high) {
            int mid = (low+high)/2;
            mergeSort(nums, tmp, low, mid);
            mergeSort(nums, tmp, mid + 1, high);
            merge(nums, tmp, low, mid, high);
        }
    }

    public static void merge(int[] nums,int[] tmp,int low,int mid,int high){
        int i = low;
        int j = mid+1;
        int m = 0;
        while(i<=mid && j<=high){
            if(nums[i]<nums[j]){
                tmp[m++] = nums[i++];
            }else {
                tmp[m++] = nums[j++];
            }
        }
        while(i<=mid){
            tmp[m++] = nums[i++];
        }
        while(j<=mid){
            tmp[m++] = nums[j++];
        }

        //将tmp数组中的值拷贝到原数组中
        for(int t = 0;t<m;t++){
            nums[low+t] = tmp[t];
        }
    }

}


