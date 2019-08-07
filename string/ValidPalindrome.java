package string;

//判断一个非空字符串删除一个字符之后能不能变成回文字符串
/**
 *思路：收尾双指针i,j
 * 当i,j指向的元素相等时，同时往前走，直到碰头或者不相等，
 * 当不相等时，判断去掉i或者j之后的字符串是否为回文串
 *
 */

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "aaaaaah";
        SolutionO g = new SolutionO();
        System.out.println(g.validPalindrome(s));
    }
}
class SolutionO {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        boolean flag = true;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if (s.charAt(i) != s.charAt(j)) {
                j--;
                //System.out.println(s.substring(i,j+1));
                if(isPalind(s.substring(i,j+1))){
                    return true;
                }else{
                    j++;
                    i++;
                    if(isPalind(s.substring(i,j+1))){
                        return true;
                    }else{
                        return false;
                    }
                }

            }
        }
        return flag;
    }
    public boolean isPalind(String s1){
        for(int i =0;i< s1.length();i++){
            if(!(s1.charAt(i) == s1.charAt(s1.length()-1-i))){
                return false;
            }
        }
        return true;
    }

}

