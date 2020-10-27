package review.dp;

public class IsMatch1 {
    public static void main(String[] args) {



    }


}
class Solution19s2{


    public boolean isMatch(String s,String p){
        int len1 = s.length();
        int len2 = p.length();

        boolean[][] res = new boolean[len1+1][len2+1];

        res[0][0] = true;
        for(int i =0;i<=len1;i++){
            for(int j =1;j<=len2;j++){
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
        return res[len1][len2];
    }

    private boolean matches(String s,String p,int i,int j){
        if (i == 0)
            return false;
        if(p.charAt(j-1) == '.')
            return true;

        return s.charAt(i-1) == p.charAt(j-1);
    }



}