package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {

    public static void main(String[] args) {

        Solution13 s = new Solution13();
        String s1 = "";
        System.out.println(s.romanToInt(s1));

    }
}

class Solution13 {
    public int romanToInt(String s) {
        Map<Character,Integer> rTonum = new HashMap<>();
        char a[] = new char[s.length()];
        int len = s.length();

        int i;
        a = s.toCharArray();
        rTonum.put('I',1);
        rTonum.put('V',5);
        rTonum.put('X',10);
        rTonum.put('L',50);
        rTonum.put('C',100);
        rTonum.put('D',500);
        rTonum.put('M',1000);
        Integer sum = 0;

        for( i =len-1;i>0;i--){
            int num1 = rTonum.get(a[i]);
            int num2 = rTonum.get(a[i-1]);
            if(num2<num1){
                sum += (num1-num2);
                i--;
            }else{
                sum+=num1;
            }
        }
//        System.out.println(i);
        if(i!=-1){
            sum+=rTonum.get(a[0]);
        }


        return sum;

    }
}