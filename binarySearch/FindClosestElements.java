package binarySearch;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class FindClosestElements {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,7};
        int target = 3;
        Solution658 s  = new Solution658();
        System.out.println(s.find(nums,target));



    }


}
class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int locate = find(arr,x);
        int l = locate;
        int i;
        int R = locate+1;
        if(R>=k){
            i = R-k;
            for(i = R-k;i<=l;i++){
                list.add(arr[i]);
            }
            return list;
        }




        return null;
    }

    public int find(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low<high){
            mid = low+((high-low)>>1);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>target){
                high = mid -1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
}