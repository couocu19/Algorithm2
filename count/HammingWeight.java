package count;

public class HammingWeight {
    public static void main(String[] args) {
        SolutionA s = new SolutionA();
        int n = 011;
        System.out.println(s.hammingWeight(n));

    }
}

class SolutionA {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        int m = 1;
        //任何一位和1进行位运算都能得到它本身。
        for(int i =0;i<32;i++){
            if((n & m)!=0)
                sum++;
            //按位与运算
            m <<= 1;
        }
        return sum;
    }
}