package string;

import java.util.*;

public class IntToRoman {
    public static void main(String[] args) {
        Solution12i s = new Solution12i();

        System.out.println( s.intToRoman(58));

    }
}

class Solution12i {
    public String intToRoman(int num) {
        Map<Integer,String> numTor = new TreeMap<>();
        List<Integer> list = new ArrayList<>();

        list.add(1000);
        list.add(900);
        list.add(500);
        list.add(400);
        list.add(100);
        list.add(90);
        list.add(50);
        list.add(40);
        list.add(10);
        list.add(9);
        list.add(5);
        list.add(4);
        list.add(1);

        StringBuilder sb = new StringBuilder("");
        numTor.put(1,"I");
        numTor.put(4,"IV");
        numTor.put(5,"V");
        numTor.put(9,"IX");
        numTor.put(10,"X");
        numTor.put(40,"XL");
        numTor.put(50,"L");
        numTor.put(90,"XC");
        numTor.put(100,"C");
        numTor.put(400,"CD");
        numTor.put(500,"D");
        numTor.put(900,"CM");
        numTor.put(1000,"M");
        if(numTor.get(num)!=null){
            return numTor.get(num);
        }


      //  while(num!=0){
            for(int i =0;i<list.size();i++){
                int num2 = list.get(i);
                while (num2<num||num2==num){
                    num -= num2;
                    sb.append(numTor.get(num2));
//                    System.out.println(sb.toString());
//                    System.out.println(num);

                }

            }

            return sb.toString();


        //}







       // return null;
    }
}