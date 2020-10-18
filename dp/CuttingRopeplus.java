package dp;

public class CuttingRopeplus {
    public static void main(String[] args) {

        Solution12II s = new Solution12II();
        int num = 120;
        System.out.println(s.cuttingRope(num));



    }
}

class Solution12II {
    //处理数据溢出的方法：(x*y)%p = ((x%p)*(y%p))%p
    public int cuttingRope(int n) {
        if(n<=3)
            return n-1;

        int b = n%3,p = 100000007;
        long ret = 1;
        int lingNums = n/3;
        for(int i =1;i<lingNums;i++)
            ret = 3*ret % p;


        if(b==0)
            return (int)(ret * 3 % p);
        if(b==1)
            return (int)(ret * 4 % p);

        return (int)(ret * 6 % p);
    }
}