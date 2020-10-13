package review.entry;

public class MinArray {

    public static void main(String[] args) {
        int[] nums = {10,1,10,10,10};
        Solution11 s = new Solution11();
        System.out.println(s.minArray(nums));


    }
}

//旋转数组的最小值
class Solution11 {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        int low = 0;
        int high = len-1;
        int mid;
        while (low<high){
            mid = (low+high)/2;
            if(numbers[mid]<numbers[high]){
                high = mid;
            }
            else if(numbers[mid]>numbers[high]){
                low = mid+1;
            }else{
                high -= 1;
            }
        }
        return numbers[low];
    }


    public int minArray1(int[] numbers) {
        int low = 0;
        int high = numbers.length-1;
        int mid;
        while (low<high){
            mid = (low+high)/2;
            if(numbers[mid]<numbers[high]){
               high = mid;
            }

            else if(numbers[mid]>numbers[high]){

                low = mid+1;
            }else{

                high--;
            }
        }

        return numbers[low];
    }
}