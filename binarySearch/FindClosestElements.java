package binarySearch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindClosestElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,10,10,10};
        int target = -3;
        int k = 4;
        Solution658s s  = new Solution658s();

       // System.out.println(s.findClosestElements(nums,k,target));

        Solution658 s1 = new Solution658();
        System.out.println(s1.findClosestElements(nums,k,target));



    }


}
class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> list = new ArrayList<>();
        if(x<arr[0]){
            for(int i =0;i<k;i++){
                list.add(arr[i]);
            }
            return list;
        }else if(x>arr[arr.length-1]){

            for(int i =arr.length-k;i<arr.length;i++){
                list.add(arr[i]);
            }
            return list;

        }


        int locate = find(arr,x);
        System.out.println(locate);
        int i = Math.max(locate-(k-1),0);
        int j = Math.min(arr.length-1,locate+(k-1));

        System.out.println(i+" "+j);
        int num = j-i+1;
        //System.out.println(num);
        while(num!=k){
           // System.out.println(num);
            if(Math.abs(arr[i] - x)<=Math.abs(arr[j]-x)){
              //  System.out.println("ok");
                j--;

            } else{
                i++;
            }
            num = j-i+1;
        }

        //System.out.println(i);
        for(int m = i;m<=j;m++){

            list.add(arr[m]);
        }

        return list;

    }

    public int find(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        int mid;
        while(low+1<high){
            mid = low+((high-low)>>1);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>target){
                high = mid;
            }else {
                low = mid;
            }
        }
        if(nums[low]<=target && Math.abs(nums[low]-target)<=Math.abs(nums[high]-target))
            return low;
        else
            return high;
    }
}






///用堆排序的思想去写，可以通过，但是速度太慢了'.'
class Solution658s{
    private int x;
    private int[] result;

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        this.x = x;
        result = new int[k];

        for(int i =0;i<k;i++){
            result[i] = 100000;
        }

        for(int i =0;i<arr.length;i++){
            System.out.println(realNum(arr[i]) +" "+realNum(result[0]));

            if(realNum(arr[i])<realNum(result[0])){
                result[0] = arr[i];
                adjustHeap(result,0,k);

                for(int a:result){
                    System.out.print(a+" ");

                }
                System.out.println();
            }

        }

        Arrays.sort(result);
       List<Integer> list = new ArrayList<>();

        for(int a:result){
            list.add(a);
        }

        return list;

    }

   private void adjustHeap(int[] nums,int index,int len){
        //调整堆为大顶堆
       int left = 2*index+1;
       int right = 2*index+2;
       int largerIndex;
       while (left<len) {
           if (right<len && realNum(nums[left]) < realNum(nums[right])) {
               largerIndex = right;
           } else {
               largerIndex = left;
           }

           //System.out.println();
           if (realNum(nums[index]) > realNum(nums[largerIndex])) {
              // System.out.println("ok");
               largerIndex = index;
           }

           swap(result,index,largerIndex);

           if (largerIndex == index) {
               break;
           }
           index = largerIndex;
           left = 2*index+1;
           right = 2*index+2;

       }

   }

    private int realNum(int num){
        return Math.abs(num-x);
    }



    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }




}

