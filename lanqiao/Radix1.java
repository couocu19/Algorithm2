package lanqiao;

import java.util.Scanner;

public class Radix1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (sc.hasNext()) {
            String s = sc.next();
            int a = Integer.parseInt(s, 16);
            System.out.println(Integer.toString(a, 8));
        }

    }

}