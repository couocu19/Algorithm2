package string;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution58 s = new Solution58();
        String s1 = "   H ed ss sdes   ";
        System.out.println(s.lengthOfLastWord(s1));

    }
}

class Solution58 {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0)
            return 0;
        int len = s.length();
        int lenth = 0;
        for(int i = len-1;i>=0;i--) {
            if (s.charAt(i) == ' '){
                if(i == len-1) {
                    len--;
                    continue;
                }
                if(s.charAt(i+1)!=' ') {
                    lenth = len - i- 1;
                    return lenth;

                }
            }
        }
        return len;

    }
}

