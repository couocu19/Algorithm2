package string;

public class IsMatch {
    public static void main(String[] args) {

        String s1 = "aab";
        String s2 = "c*a*b";

        Solution10 s = new Solution10();
        System.out.println(s.isMatch(s1,s2));
    }
}


class Solution10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m+1][n+1];
        f[0][0] = true;
        for(int i =0;i<=m;++i){
            for(int j =1;j<=n;++j){
                if(p.charAt(j-1) == '*'){

                    //*号之前的字符和遍历到的s串的第i个字符不相等
                    f[i][j] = f[i][j-2];
                    //*号之前的字符和遍历到的s串的第i个字符相等
                    //两种情况只要有一种情况满足即可，所以要对这两种情况进行或运算
                    if(matches(s,p,i,j-1)){
                        f[i][j] = (f[i][j] || f[i-1][j]);
                    }
                }else{
                    if(matches(s,p,i,j)){
                        f[i][j] = f[i-1][j-1];

                    }
                }

            }

        }

        return f[m][n] ;

    }



    private boolean matches(String s,String p,int i,int j){
        if(i == 0){
            return false;
        }
        if(p.charAt(j-1) == '.'){
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);

    }
}