package lanqiao;

import java.util.Scanner;
public class LuoXuan {
    public static void main(String[] args) {
        int num[][] = {{1,2,3,4,5},{14,15,16,17,6},{13,20,19,18,7},{12,11,10,9,8
}};
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(num[n-1][m-1]);

    }
}
