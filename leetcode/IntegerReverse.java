package leetcode;
import java.util.*;
public class IntegerReverse {
    public static void main(String[] args) {

        Scanner w = new Scanner(System.in);
        Solution01 aa = new Solution01();
        int x = w.nextInt();
        System.out.println(aa.reverse(x));

    }
}

class Solution01{
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            int p = x % 10;
            x /= 10;

            if(rev > Integer.MAX_VALUE/10) return 0;
            if(rev < Integer.MIN_VALUE/10) return 0;

            rev = rev * 10 +p;

        }

        return rev;

        }
    }
