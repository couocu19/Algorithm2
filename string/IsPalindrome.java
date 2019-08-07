package string;

public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        SolutionD d = new SolutionD();
        System.out.println(d.isPalindrome(s));


    }
}

//验证一个字符串是否是回文串
class SolutionD {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder("");
        for(int i =0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(!isDigit(ch) && !isCharacter(ch))
                continue;
            else{
                sb.append(ch);

            }
        }
        //将字符串中的大写字母转为小写
        String s1 = sb.toString().toLowerCase();

        for(int i =0;i<s1.length();i++){
            if(!(s1.charAt(i) == s1.charAt(s1.length()-1-i))){
                return false;
            }
        }
        return true;


    }


    public boolean isDigit(Character ch){
        if(ch>='0' && ch<='9')
            return true;
        else
            return false;
    }

    public boolean isCharacter(Character ch){
        if(ch>='A' && ch<='Z'  ||  ch>='a' && ch<='z'){
            return true;
        }else{
            return false;
        }
    }
}

