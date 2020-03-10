package lanqiao;

import java.util.Scanner;

public class Fibonacci {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fibonacci(n));

    }

    static int fibonacci(int f){
        int result = 0;
        if(f == 1 || f == 2){
            return 1;
        }else {
            result = (fibonacci(f - 1) + fibonacci(f - 2)) % 10007;
        }

        return result;

    }
}
