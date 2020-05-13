package data;

public class Divide {
    public static void main(String[] args) {
        Solution29 s = new Solution29();
        int a = 2147483646;
        int b = 1;
        System.out.println(s.divide(a,b));
    }
}

class Solution29 {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor)
            return 1;
        boolean flag = (dividend>0) ^ (divisor>0);
        if(dividend>0)
            dividend = -dividend;
        if(divisor>0)
            divisor = -divisor;
        int result = -1;
        int tempResult;
        int tempDivisor = divisor;
        while(dividend<=divisor){

            while(dividend<=(tempDivisor<<1)) {
            //    System.out.println(tempDivisor);
                if(tempDivisor <= Integer.MIN_VALUE){
                    break;
                }
                tempDivisor = tempDivisor<<1;
                result += result;
               // System.out.println(result);
            }
            dividend -= tempDivisor;
            System.out.println(dividend);
            if(dividend<=divisor) {
                dividend -= divisor;
                result -= 1;
            }
        }


        if(flag == false && result == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        if(flag == false)
            return (-1*result);

        return result;

    }
}