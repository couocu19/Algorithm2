package review.dp;

public class MinDistance {
    public static void main(String[] args) {



    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if(n * m == 0)
            return n+m;
        int[][] D = new int[n+1][m+1];
        for(int i =0;i< n+1 ;i++){
            D[i][0] = i;
        }
        for(int j =0;j< m+1;j++){
            D[0][j] = j;
        }

        for(int i = 1;i< n+1;i++){
            for(int j = 1;j< m+1;j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];

                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }

        return D[n][m];
    }


    public int minDistance1(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(m * n == 0)
            return m+n;
        int[][] D = new int[n+1][m+1];

        //初始化
        for(int i = 0;i<n+1;i++){
            D[i][0] = i;
        }

        //初始化
        for(int j =0;j<m+1;j++){
            D[0][j] = j;
        }

        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                int left = D[i-1][j] +1;
                int down = D[i][j-1] +1;
                int left_down = D[i-1][j-1] ;
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    left_down += 1;
                }
                D[i][j] = Math.min(left,Math.min(down,left_down));

            }
        }
        return D[n][m];

    }
}