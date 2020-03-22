package lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Yuanyin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');
        int n = 1;
        String s = sc.next();
        int length = s.length();
        if(list.contains(s.charAt(0))){
            System.out.println("no");
        }
        for(int i =0;i<length-1;i++){
            if(!list.contains(s.charAt(i))){
                if(list.contains(s.charAt(i+1))){
                    n++;
                }
            }

            if(list.contains(s.charAt(i))){
                if(!list.contains(s.charAt(i+1))){
                    n++;
                }

            }
        }
        if(n == 4){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }



    }
}
