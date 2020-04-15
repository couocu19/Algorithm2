package collection;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        String s = "MMMMMMMMMDCCCLXXV";
        Solution13 s13 = new Solution13();
        System.out.println(s13.romanToInt(s));

    }

}

class Solution13 {


    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int len = s.length();
        int sum  = 0;
        sum += map.get(s.charAt(len-1));
        for(int i =len-2;i>=0;i--){
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                sum -= map.get(s.charAt(i));
            }else {
                sum += map.get(s.charAt(i));
            }
        }

        return sum;



    }
}
