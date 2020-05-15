package data;

public class Divide {
    public static void main(String[] args) {
        Solution29 s = new Solution29();
        int a = -10;
        int b = 3;
        System.out.println(s.divide(a,b));
    }
}

class Solution29 {
    public int divide(int dividend, int divisor)  {
        if(dividend == divisor)
            return 1;
        boolean flag = (dividend>0) ^ (divisor>0);
        if(dividend>0)
            dividend = -dividend;
        if(divisor>0)
            divisor = -divisor;
        int result = 0;
        int tempResult = -1;
        int tempDivisor = divisor;
        while(dividend<=divisor){
            tempResult = -1;
            tempDivisor = divisor;
            while(dividend<=(tempDivisor<<1)) {
                if(tempDivisor <= Integer.MIN_VALUE || (tempDivisor<<1)>0){
//                    System.out.println("溢出");
                    break;
                }
                tempDivisor = tempDivisor<<1;
                tempResult += tempResult;
               // System.out.println(tempDivisor);
            }

            result += tempResult;
            dividend -= tempDivisor;
//            System.out.println();
//            System.out.println(dividend);
        }

        if(flag == false && result == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        //如果两数都为正数/两数都为负数(两数同号)
        if(flag == false)
            return (-1*result);
        return result;

    }
}