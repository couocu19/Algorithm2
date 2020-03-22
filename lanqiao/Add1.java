package lanqiao;

import java.util.Scanner;

public class Add1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer m = sc.nextInt();
        String[] s = new String[n];
        Integer[][] flag = null;
        for(int i =0;i<n;i++){
            s[i] = sc.next();
        }
        Integer k = sc.nextInt();
        for(int h =0;h<k;h++){
            flag = new Integer[n][m];
            for(int i =0;i<n;i++){
                for(int j =0;j<m;j++){
                    flag[i][j] = 0;
                }
            }
            for(int i =0;i<n;i++){
                for(int j =0;j<m;j++){
                    if(s[i].charAt(j) == 'g' && flag[i][j] == 0){
                        if((i-1)>=0 && s[i-1].charAt(j)!='g'){
                            StringBuilder sb = new StringBuilder(s[i-1]);
                            sb.replace(j,j+1,"g");
                            s[i-1] = sb.toString();
                        }
                        if((j-1)>=0 && s[i].charAt(j-1)!='g'){
                            StringBuilder sb = new StringBuilder(s[i]);
                            sb.replace(j-1,j,"g");
                            s[i] = sb.toString();
                        }
                        if((i+1)<n && s[i+1].charAt(j)!='g'){
                            StringBuilder sb = new StringBuilder(s[i+1]);
                            sb.replace(j,j+1,"g");
                            s[i+1] = sb.toString();
                            flag[i+1][j] = 1;
                        }
                        if((j+1)<m && s[i].charAt(j+1)!='g'){
                            StringBuilder sb = new StringBuilder(s[i]);
                            sb.replace(j+1,j+2,"g");
                            s[i] = sb.toString();
                            flag[i][j+1] = 1;
                        }

                    }
                }

            }


        }

        for(int i =0;i<n;i++){
            System.out.println(s[i]);
        }

    }
}
