package lanqiao;

import java.util.Scanner;

public class Jiami {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        for(int i =0;i<len;i++){
            int a = Integer.valueOf(s.charAt(i))+3;
            char b = (char)a;
            System.out.print(b);
        }
    }
}
