package lanqiao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Baidong {
    public static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int num = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for(int i =3;i<=(num+1);i++){
            find(num,len,list);
            list = new ArrayList<>();
            list.add(i);
        }
        System.out.println(result.size()%10000);

    }
    public static void find(int num,int len,List<Integer> s){
        if(s.size() == 3) {
            result.add(new ArrayList<>(s));
            return;
        }
            for(int i = 1;i<=num;i++){
                if(s.size()%2 == 1){
                    if(i<s.get(s.size()-1)){
                        s.add(i);
                        find(num,len,s);
                        s.remove(s.size()-1);
                    }
                }else{
                    if(i>s.get(s.size()-1)){
                        s.add(i);
                        find(num,len,s);
                        s.remove(s.size()-1);
                    }
                }
            }
    }
}
