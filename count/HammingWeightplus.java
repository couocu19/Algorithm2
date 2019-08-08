package count;

public class HammingWeightplus {
    public static void main(String[] args) {

    }
}

//按位与运算的优化
//如果n的值不为0，则每次都与(n-1) 进行与运算,能将二进制串n的最后一个1变为0.
class S1{
    public int hammingWeight(int n) {
        int sum = 0;
        while(n!=0){
            sum++;
            n &= (n-1);
        }
        return sum;
    }

}
