package lanqiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//进制转换
public class Radix {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        Radix radix = new Radix();
       int n = sc.nextInt();
        for(int i =0;i<n;i++){
            String a = sc.next();
            int a1 = radix.toTen(a);
            System.out.println(radix.tenToEight(a1));
        }

        return ;

    }

    private int toTen(String s){
        Map<Character,Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);
        int len = s.length();
        int n = 0;
        int r = 0;
        for(int i =len-1;i>=0;i--){

            int f = 0;
            try {
                f = Integer.parseInt(String.valueOf(s.charAt(i)));
            } catch (NumberFormatException e) {
                f = map.get(s.charAt(i));
            }

            double m =  Math.pow(16,n++);

            r+=f*m;
        }
        return Integer.valueOf(r);
    }

    private int tenToEight(int b){
        StringBuilder sb = new StringBuilder("");
        while(b!=0){
            int n = b%8;
            String s = String.valueOf(n);
            sb.append(s);
            b/=8;
        }

        return Integer.valueOf(sb.reverse().toString());
    }
}
