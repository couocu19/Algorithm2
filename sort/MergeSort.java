package sort;

/**
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {11,44,23,67,88,65,34,48,9,12};
        int[] tmp = new int[arr.length];
        mergeSort(arr,tmp,0,arr.length-1);
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }

    public static void merge(int[] arr,int[] tmp,int low,int high,int mid){
        int i = 0;
        int j = low,k = mid+1;
        while(j <= mid && k <=high){
            if(arr[j] < arr[k]){
                tmp[i++] = arr[j++];
            }else{
                tmp[i++] = arr[k++];
            }
        }

        while(j <= mid){
            tmp[i++] = arr[j++];
        }

        while(k <= high){
            tmp[i++] = arr[k++];
        }

        for(int t = 0;t<i;t++){
            arr[low+t] = tmp[t];
        }
    }
    public static void mergeSort(int[] arr,int[] tmp,int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(arr,tmp,low,mid);
            mergeSort(arr,tmp,mid+1,high);
            merge(arr,tmp,low,high,mid);
        }
    }
}


