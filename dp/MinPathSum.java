package dp;

//64题
public class MinPathSum {
    public static void main(String[] args) {
        int[][] a = {{1,3,1},{1,5,1},{4,2,1}};
        Solutionf s = new Solutionf();
        System.out.println(s.minPathSum(a));

    }
}

class Solutionf {
    public int minPathSum(int[][] grid) {
        int len1 = grid.length;
        int len2 = grid[0].length;
        int dp[][] = new int[len1][len2];
        //倒着算！
        for(int i = len1-1;i>=0;i--){
            for(int j = len2-1;j>=0;j--){

                if(i==len1-1 && j!=len2-1){
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                }

                else if(j ==len2-1 && i!=len1-1){
                    dp[i][j] = grid[i][j] +dp[i+1][j];
                }
                else if(j!=len2-1 && i!=len1-1){
                    dp[i][j] = grid[i][j] +Math.min(dp[i+1][j],dp[i][j+1]);
                }else
                    dp[i][j] = grid[i][j];
            }

        }

        return dp[0][0];


    }
}

//class Solutionf {
//    public int minPathSum(int[][] grid) {
//        int[][] dp = new int[grid.length][grid[0].length];
//        for (int i = grid.length - 1; i >= 0; i--) {
//            for (int j = grid[0].length - 1; j >= 0; j--) {
//                if(i == grid.length - 1 && j != grid[0].length - 1)
//                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
//                else if(j == grid[0].length - 1 && i != grid.length - 1)
//                    dp[i][j] = grid[i][j] + dp[i + 1][j];
//                else if(j != grid[0].length - 1 && i != grid.length - 1)
//                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
//                else
//                    dp[i][j] = grid[i][j];
//            }
//        }
//        return dp[0][0];
//    }
//}
//
