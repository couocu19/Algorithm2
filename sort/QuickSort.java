package sort;

public class QuickSort {

    public static void main(String[] args) {

        int nums[] = {2,-1,1,-3,8,7,6};
        qsort(nums,0,nums.length-1);

        for(int a:nums) {
            System.out.print(a + " ");
        }
    }





    public static void qsort(int[] arr,int low,int high){
        if(low<high){
            int pos = partition(arr,low,high);

            qsort(arr,low,pos-1);
            qsort(arr,pos+1,high);
        }

    }

    public static int partition(int[] arr,int low,int high){
        int key = arr[low];
        while(low<high){
            while(low<high && arr[high]>=key)
                high--;

           // System.out.println(arr[high]);
            arr[low] = arr[high];

            while(low<high && arr[low]<=key)
                low++;


            System.out.println(arr[low]);

            arr[high] = arr[low];
        }
        arr[low] = key;
        return low;
    }
}
