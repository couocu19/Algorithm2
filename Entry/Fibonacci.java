package Entry;

public class Fibonacci {
    public static void main(String[] args) {




    }


    //时间复杂度 O(n)
    public static long f(int n){
        int res[] = {0,1};
        if(n<2)
            return res[n];
        long fibOne = 1;
        long fibTwo = 0;
        long fibN = 0;
        for(int i =2;i<=n;i++){
            fibN = fibOne+fibTwo;
            fibTwo = fibOne;
            fibOne = fibN;
        }
        return fibN;
    }



}
