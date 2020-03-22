package lanqiao;

import java.util.Scanner;

public class ThreeYuan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Integer a[] = new Integer[n];
        for(int i =0;i<n;i++){
            a[i] = sc.nextInt();
        }
        if(n<3){
            System.out.println(0);
            return;
        }

        Integer sum = 0;
        Integer flag = 0;
        for(int i =1;i<n-1;i++){
            flag = 0;
          for(int j =0;j<i;j++){
              if(a[j]<a[i]){
                  flag = 1;
                 for(int k = i+1;k<n;k++){
                     if(a[i]<a[k]){
                        // System.out.println(a[k]);
                         sum++;
                         break;
                     }
                 }
              }
              if(flag == 1){
                  break;
              }
          }
        }

        System.out.println(sum);

    }
}
