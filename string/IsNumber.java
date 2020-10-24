package string;

public class IsNumber {
    public static void main(String[] args) {



    }


}

class Solution20s{
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0)
            return false;

        s = s.trim();
        try {
            double a = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }

        char c = s.charAt(s.length()-1);

        return (c >= '0' && c <= '9')||c == '.';

    }
}

class Solution20ss{
    public boolean isNumber(String s) {




    }




}

