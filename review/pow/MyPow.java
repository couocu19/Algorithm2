package review.pow;

public class MyPow {
    public static void main(String[] args) {



    }
}

class Solution16 {
    public double myPow(double x, int n) {
        if(n == 1)
            return x;
        if(n == 0)
            return 0;
        double ret = 1.0;
        long b = n;

        if(b<0){
            b = -b;
            x = 1/x;
        }
        while (b>0){
            if((b&1)==1)
                ret*=x;
            x *= x;
            b>>=1;
        }

        return ret;
    }

    public double myPow1(double x, int n) {
        if(n == 1)
            return x;
        if(n == 0)
            return 1;

        long b = n;
        double ret = 1.0;

        if(n<0){
            b = -b;
            x = 1/x;
        }
        while (b>0){

            if((b&1) == 1){
                ret*=x;
            }
            x*=x;
            b>>=1;
        }
        return ret;
    }
}