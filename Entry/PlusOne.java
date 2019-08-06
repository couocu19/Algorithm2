package Entry;

import java.lang.String;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        Solutiony s = new Solutiony();
        int[] num = {9,8,7,6,5,4,3,2,1,0};
        System.out.println(s.plusOne(num));

    }
}
//这个方法不适用于数组过长的情况
class Solutiony {
    public int[] plusOne(int[] digits) {
        long num = 0;
        int len = digits.length;
        long j = 1;
        for(int i =len-1;i>=0;i--){
            num += digits[i]*j;
            j*=10;
//            System.out.println(num);
        }
        num++;
//        System.out.println(num);
        String s = Long.toString(num) ;
//        System.out.println(s);
        int[] plus = new int[s.length()];
        for(int i = 0;i<s.length();i++){
            int flag = s.charAt(i)-'0';
            plus[i] = flag;
        }
        return plus;

    }
}

