package lanqiao;

import java.util.Scanner;

public class Fibonacci1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result[] = new int[n+1];
        result[0] = result[1] =1;
        for(int i =2;i<n;i++){
            result[i] = (result[i-1] + result[i-2])%10007;
        }
        System.out.println(result[n-1]);

    }


}
