package count;

public class OuntAndSay {
    public static void main(String[] args) {
        int n = 6;
        Solution38 s = new Solution38();
        System.out.println(s.countAndSay(n));

    }
}

class Solution38 {
    public String countAndSay(int n) {
        String s = "11";
        int t = 1;
        if(n == 1)
            return "1";
        if(n == 2) {
            s = "11";
            return s;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i =3;i<=n;i++){
            for(int j =0;j<s.length();j++){
                if( ((j+1)<s.length())&& s.charAt(j)==s.charAt(j+1)){
                    t++;
                }else{
                    String t1 = String.valueOf(t);
                    sb.append(t1+s.charAt(j));
                    t = 1;
                }
            }
            s = sb.toString();
            sb.delete(0,s.length());
            //System.out.println(s);


        }
        return s;

    }

}