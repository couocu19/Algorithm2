package binarySearch;

public class Sqrt {
    public static void main(String[] args) {
        Solution s = new Solution();

        int x = 8;
        System.out.println(s.sqrt(2147395599));



    }
}

class Solution{
    public int sqrt(int x){
        long num;
        int low = 0;
        int high = (x>>1)+1;
        int mid ;
        while(low<=high){
            mid = (low+high)/2;
            //防止溢出
            num = (long)mid * (long)mid;
            if(num == x)
                return mid;

            if(num<x) {
                low = mid+1;
            }else{
                high = mid-1;
            }

        }
        return (low-1);
    }

}
