package lanqiao;

import java.util.Arrays;
import java.util.Scanner;

public class Jiemu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer m = sc.nextInt();
        Integer r[] = new Integer[m];
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int fLen = n - m;
        int fi = 0;
        int t = 0;
        for (int i = fi; i < fLen; i++) {
            int newLen = fLen + 1;
            int num[] = (int[]) Arrays.copyOfRange(a, fi, newLen);
            Arrays.sort(num);
            r[t] = num[num.length - 1];
            t++;
            int locate = Jiemu.getIndex(a,num[num.length - 1]);
//            fi
        }


    }

    public static int getIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;                  //字符串时，换为 equals
            }
        }
        return -1;//如果未找到返回-1

    }
}
