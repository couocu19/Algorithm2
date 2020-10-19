package pow;

public class MyPow {
    public static void main(String[] args) {
        Solution16 s = new Solution16();
        double x = 2;
        int n = 10;
        System.out.println(s.myPow1(x,n));
        //System.out.println(Integer.MAX_VALUE);
       // System.out.println(Integer.MIN_VALUE);




    }
}

class Solution16 {
    public double myPow(double x, int n) {

        if(n==0)
            return 1;
        if(n == 1)
            return x;

        if(x == 1.00000)
            return 1.00000;

        if(x == -1.000000){
            if(n%2==0)
                return 1.00000;
            else
                return -1.00000;
        }
        if(n == Integer.MIN_VALUE || x == 0)
            return 0;

        double res = 1;
        int f = n;
        if(n<0){
            f = -n;
        }
        for(int i =0;i<f;i++){
            res = res*x;
        }

        if(f == -n){
            res = 1/res;
        }

        return res;

    }


    public double myPow1(double x, int n){
        if(n == 0)
            return 1;
        if(n == 1)
            return x;

        long b = n;
        double res = 1.0;
        if(b<0){
            x = 1/x;
            b = -b;
        }

        //利用数学公式:二进制转十进制--> num = 2^0*b1+2^1*b2+2^2*b3……+2^(n-1)*bn
        //其中bi表示的是该数的二进制的每一位所表示的数字

        //幂的二进制展开： x^n = x^(2^0*b1+2^1*b2+2^2*b3……+2^(n-1)*bn)
        //将这个公式展开就是用一个循环，根据位移运算计算每一位的b的值是1还是0，然后每次要循环赋值计算 x = x^2即可
        while (b>0){
            if((b&1)==1)
                res *= x;
            x*=x;

            b>>=1;
        }

        return res;

    }


}