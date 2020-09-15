package string;

public class IsMatch3 {
    public static void main(String[] args) {


    }
}

//使用动态规划来完成
class Solution10sss {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] res = new boolean[m+1][n+1];
        res[0][0] = true;
//        if(m == 0 && n == 0)
//            return true;
//        if(n == 0 || m>0 )
//            return false;
        for(int i =0;i<=m;++i){
            for(int j =1;j<=n;++j){
                if(p.charAt(j-1) == '*'){
                    res[i][j] = res[i][j-2];
                    if(matches(s,p,i,j-1)){
                        res[i][j] = (res[i][j] || res[i-1][j]);
                    }
                }else{
                    if(matches(s,p,i,j)){
                        res[i][j] = res[i-1][j-1];
                    }
                }
            }
        }

        return res[m][n];

    }

    private boolean matches(String s,String p,int i,int j){
        if(i == 0)
            return false;
        if(p.charAt(j-1) == '.')
            return true;
        return s.charAt(i-1) == p.charAt(j-1);

    }




}