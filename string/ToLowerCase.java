package string;

import java.util.Arrays;

public class ToLowerCase {
    public static void main(String[] args) {
        Solution709 s = new Solution709();
        String m = "H";
        System.out.println(s.toLowerCase(m));

    }
}

class Solution709 {
    public String toLowerCase(String str) {
        if(str.length() == 0)
            return "";
        char c[] = str.toCharArray();
        for(int i =0;i<str.length();i++){

            if(c[i] >= 'A' && c[i] <='Z'){
                c[i] +=32;
            }
        }
        String s2 = new String(c);
        return s2;

    }
}
