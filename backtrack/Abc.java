package backtrack;

import java.util.Scanner;

public class Abc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int sum = 0;
        for(int i =1;i<=n;i++){
            if(i%a!=0 && i%b!=0 &&i%c!=0) {
                sum++;
            }
        }

        System.out.println(sum);
    }
}
