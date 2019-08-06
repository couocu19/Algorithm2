package Entry;

import java.util.Arrays;

public class PlusOne2 {
    public static void main(String[] args) {
        int[] test = {1,2,3,4};
        System.out.println(Arrays.toString(test));
        test = new int[test.length+1];
        System.out.println(Arrays.toString(test));


    }
}
//别人写的题解
class Solution {
    public int[] plusOne(int[] digits) {
        //这个题解太强了……
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}


