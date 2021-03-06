package bitwise;

public class HammingWeight {
    public static void main(String[] args) {



    }
}

class Solution15s {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n!=0){
            count += n&1;
            n>>>=1;
        }
        return count;
    }




    public int hammingWeight1(int n){
        int count = 0;
        while (n!=0){
            count++;
            n = (n-1)&n;
        }
        return count;
    }

    public int hammingWeight2(int n){
        int count = 0;

        while (n!=0){
            count+=n&1;
            n>>>=1;
        }
        return count;
    }

    public int hammingWeight3(int n){
        int count = 0;
        while (n!=0){
            count++;

            n = (n-1)&n;

        }
        return count;
    }






}
