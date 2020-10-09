package review.binarySearch;

public class Search {
    public static void main(String[] args) {



    }

}


class Solution {
    public int search(int[] arr,int target){
        int low = 0;
        int high = arr.length-1;
        int mid;

        while (low<=high){
            mid = (low+high)/2;

            if(target>arr[mid]){
                if(target>=arr[low] && arr[mid]<arr[low]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                if(target<=arr[high] && arr[mid]>arr[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        if(low<arr.length && arr[low] == target)
            return low;
        return -1;
    }



}