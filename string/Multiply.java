package string;


public class Multiply {
    public static void main(String[] args) {
        Solution43 d = new Solution43();
        String num1 = "0";
        String num2 = "1111";
        System.out.println(d.multiply(num1,num2));
    }

}
class Solution43 {
    public String multiply(String num1, String num2) {
        if(num1 == "0" || num2 == "0")
            return "0";
        else {
            int[] ans = new int[12100];
            int t = 1;
            int len = Math.min(num1.length(), num2.length());
            if (num1.length() < num2.length()) {
                String temp = num1;
                num1 = num2;
                num2 = temp;
            }
            StringBuilder sb = new StringBuilder(num1);
            int k = -1;
            for (int i = num2.length() - 1; i >= 0; i--) {
                k = 0;
                for (int j = sb.toString().length() - 1; j >= 0; j--) {
                    int a = num2.charAt(i) - '0';
                    int b = sb.toString().charAt(j) - '0';
                    ans[k] += a * b;
                    ans[k + 1] += ans[k] / 10;
                    ans[k] = ans[k] % 10;
                    k++;
                }
                sb.append('0');
            }
            String ans1 = "";
            int llen = num1.length() * num2.length() + 1;
            for (int i = llen - 1; i >= 0; i--) {
                if (ans[llen - 1] == 0)
                    llen--;
                else {
                    ans1 = ans1 + ans[i];
                }
            }

            return ans1;
        }

    }
}