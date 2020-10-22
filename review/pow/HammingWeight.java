package review.pow;

public class HammingWeight {
    public static void main(String[] args) {



    }
}

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }
}
