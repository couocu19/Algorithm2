package leetcode;

import java.util.Scanner;

public class Palidrome {
    public static void main(String[] args) {
        Scanner w = new Scanner(System.in);
        Solution6 h = new Solution6();
        int x = w.nextInt();
        System.out.println(h.isPalindrome(x));


    }

}

class Solution6 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);

        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;

    }
}

