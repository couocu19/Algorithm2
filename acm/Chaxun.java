package acm;

import java.util.Scanner;

public class Chaxun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num[] = new int[n];
        int m = sc.nextInt();
        for(int i =0;i<n;i++){
            num[i] = sc.nextInt();
        }
        for (int i =0;i<m;i++){
            String s = sc.next();
            if(s.charAt(0)=='q'){
                int x = Integer.parseInt(s.substring(1,2));
                if(x == n){
                    System.out.println(0);
                }else{
                    int result = 0;
                    for(int j =x;j<n;j++){
                        if(num[j]<=num[x-1]) {
                            int min = Integer.MAX_VALUE;
                            for(int k = (x-1);k<=j;k++) {
                                if (num[k] < min) {
                                    min = num[k];
                                }
                            }
                            if(num[j] == min){
                                result++;
                            }
                        }
                    }
                    System.out.println(result);
                }
            }else if(s.charAt(0)=='c'){
                int l = Integer.parseInt(s.substring(1,2));
                int r = Integer.parseInt(s.substring(2,3));
                int k = Integer.parseInt(s.substring(3,4));
                for(int j =(l-1);j<r;j++){
                    num[j]+=k;
                }
            }

        }



    }
}
