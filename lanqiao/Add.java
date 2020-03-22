package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class Add {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 1;i<=n;i++) {
            if (i < 10) {
                //System.out.println(i);
                sum++;
                continue;
            } else {
                String s = String.valueOf(i);
                char[] s1 = s.toCharArray();
                Arrays.sort(s1);
                StringBuffer sb = new StringBuffer("");
                for (char a : s1) {
                    sb.append(a);
                }
               // System.out.println(sb.toString());
                if (sb.toString().equals(s)) {
                   // System.out.println(s);
                    sum++;
                }
            }
        }

        System.out.println(sum);


    }
}
