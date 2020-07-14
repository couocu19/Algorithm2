package binarySearch;

public class Search {
    public static void main(String[] args) {
        int arr[] = {15,16,19,20,25,1,3,4,5,7,10,14};
        int target = 5;
        Solution1003s s = new Solution1003s();
        System.out.println(s.search(arr,target));


    }



}

class Solution1003 {
    public int search(int[] arr, int target) {
        int i;
        for(i = 0;i<arr.length;i++){
            if(arr[i] == target){
                return i;
            }

        }

        return -1;
    }
}

class Solution1003s{
    public int search(int[] arr, int target) {
        int minL = getMin(arr,0,arr.length-1);
        int min = arr[minL];
        if(target == min)
            return minL;
        if(target>min){
            return binarySearch(arr,minL,arr.length-1,target);
        }else{
            return binarySearch(arr,0,minL,target);
        }
    }

    private int binarySearch(int[] arr,int start,int end,int target){
        int mid = 0;
        while(start<=end){
            mid = (start+end)/2;
            if(target == arr[mid])
                return mid;
            if(target>arr[mid])
                start = mid+1;
            else
                end = mid-1;
        }

        return -1;


    }


    private int getMin(int[] arr,int start,int end){
        int len = arr.length;

        if(arr[0]<arr[len-1])
            return 0;

        if(start == end)
            return start;
        int mid = (start+end)/2;
        if(arr[mid]<arr[mid-1]){
            return mid;
        }
        if(arr[mid]>arr[mid+1]){
            return mid+1;
        }
        if(arr[mid]>arr[start])
            return getMin(arr,mid+1,end);
        if(arr[mid]<arr[end])
            return getMin(arr,start,mid);
        else
            return Math.min(getMin(arr,start,mid-1),
                            getMin(arr,mid+1,end));
    }

}

class Solution1003ss{
    public int search(int[] arr, int target) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = l + (h - l >> 1);
            if (arr[mid] >= target) {
                if (arr[h] < arr[mid] && arr[h] >= target) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            } else {
                if (arr[mid] < arr[l] && target >= arr[l]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        if (l < arr.length && arr[l] == target) return l;
        return -1;
    }
}