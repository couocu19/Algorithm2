package lanqiao;

import java.util.Scanner;

public class Tree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer m = sc.nextInt();
        Character[][] s = new Character[n][m];
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++) {
                s[i][j] =sc.next().charAt(0);
            }
        }
        Integer k = sc.nextInt();
        for(int h =0;h<k;h++){
            System.out.println("ok");
            for(int i =0;i<n;i++){
                for(int j = 0;j<m;j++) {
                    if(s[i][j] == 'g'){
                        if((i-1)>0 && s[i-1][j]!='g'){
                            s[i-1][j] = 'g';
                        }
                        if((j-1)>0 && s[i][j-1]!='g'){
                            s[i][j-1] = 'g';
                        }
                        if((j+1)<m && s[i][j+1]!='g'){
                            s[i][j+1] = 'g';
                        }
                        if((i+1)<n && s[i+1][j]!='g'){
                            s[i+1][j] = 'g';
                        }

                    }
                }
            }


        }

        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++) {
                System.out.println(s[i][j]);
            }
        }





    }

}
