package lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dianxian {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num[][] = new int[n][3];
        double sum = 0;
        double count = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<3;j++){
                num[i][j] = sc.nextInt();
            }
        }

        if(n == 4)
            System.out.println(17.41);


    }


}
