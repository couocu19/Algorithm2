package review.binarySearch;

public class MySqrt {
    public static void main(String[] args) {

        int num = 6;
        //System.out.println(num>>1);
        Solution69 s = new Solution69();
        System.out.println(s.mySqrt(num));


    }
}



class Solution69 {
    public int mySqrt(int x) {
        long num;
        int low = 0;
        int high = (x>>1)+1;
        int mid;
        while(low<=high){
            mid = (low+high)/2;
            num = mid*mid;
            if(num == x){
                return mid;
            }
            if(num<x){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return (low-1);
    }

    //利用数学公式来计算

    //根号x = e的1/2*lnx -->可以推出来
    public int mySqrt1(int x){
        if(x==0)
            return 0;
        int ans = (int)Math.exp(0.5*Math.log(x));

        return (long)(ans+1)*(ans+1)<=x? (ans+1):ans;
    }
}