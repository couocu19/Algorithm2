package top100;

public class No7 {
    public static void main(String[] args) {
        int a = 1534236469;
        Solution7 s = new Solution7();
        System.out.println(s.reverse(a));

    }
}

class Solution7 {
    public int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder str1 = new StringBuilder(str);
        int flag = 0;
        int len = str.length();
        if(len == 0 || len == 1)
            return x;
        StringBuilder sb = new StringBuilder("");
        if(str1.charAt(0) == '-'){
            sb.append('-');
            flag = 1;
        }
        int k =len-1;
        //处理结尾0
        while (str1.charAt(k) == '0'){
            str1.deleteCharAt(k);
            k--;
        }
        len = str1.length();
        for(int i = (len-1);i>=1;i--){
            sb.append(str1.charAt(i));
        }
        if(flag == 0)
            sb.append(str1.charAt(0));
        int res;
        try {

             res = Integer.parseInt(sb.toString());
        }catch (Exception e){
            return 0;
        }


        return res;
    }
}