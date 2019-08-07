package string;

public class ReverseWords {
    public static void main(String[] args) {
        SolutionS s = new SolutionS();
        String l = " hello world! ";
        System.out.println(s.reverseWords(l));
    }
}

class SolutionS {
    public String reverseWords(String s) {
        boolean flagg = true;
        if(s.length() == 0)
            return "";
       for(int i =0;i<s.length();i++){
           if(s.charAt(i)!=' ') {
               flagg = false;
               break;
           }
       }
       if(flagg)
           return "";
        int flag = 0;
        StringBuilder sb = new StringBuilder("");
        StringBuilder sb1 = new StringBuilder(" ");
        sb1.append(s);
        int len = sb1.length();
        int j = sb1.length();
        for(int i =len-1;i>=0;i--){
            if(sb1.charAt(i) == ' '){
                if(i+1 == len) {
                    len--;
                    j--;
                    continue;
                }
                if(sb1.charAt(i+1)!=' '){
                    while(sb1.charAt(j-1)==' ')
                        j--;
                    sb.append(sb1.substring(i+1,j));
                    sb.append(' ');
                    j = i;
                }

            }
        }
        int len2 = sb.length()-1;
        String s2 = sb.substring(0,len2);
        return s2;

    }
}

