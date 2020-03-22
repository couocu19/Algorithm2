package lanqiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JirMu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            order[i] = num[i];
        }
        sc.close();
        Arrays.sort(order);
        ArrayList<String> list = new ArrayList<String>();
        for (int i = n - m; i < n; i++) {
            list.add(order[i]+"");
        }
        StringBuilder sb = new StringBuilder("");
        for (int i : num) {
            if (list.contains(i+"")) {
                list.remove(i+"");
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }
}
