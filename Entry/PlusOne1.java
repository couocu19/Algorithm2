package Entry;

import java.util.Arrays;

public class PlusOne1 {
    public static void main(String[] args) {
        Solutionf s = new Solutionf();
        int[] num = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
        System.out.println(Arrays.toString(s.plusOne(num)));

    }
}
class Solutionf {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if(digits[len-1]<9){
            digits[len-1]+=1;
            System.out.println(Arrays.toString(digits));
            return digits;
        }else if(digits[len-1] >=9){
                digits[len-1]+=1;
            for(int i =len-1;i>0;i--){
                int flag = digits[i]/10;
                digits[i] = digits[i]%10;
                digits[i-1] = digits[i-1]+flag;
            }
            if(digits[0] == 10){
                int[] plus = new int[digits.length+1];
                plus[0] = 1;
                plus[1] = 0;
                int t = 1;
                for(int k = 2;k<plus.length;k++){
                    plus[k] = digits[t++];
                }
                return plus;
            }
        }
      return digits;
    }
}
