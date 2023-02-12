package top100;

public class No48 {
    public static void main(String[] args) {


    }
}

class Solution48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        //转置
        for(int i = 0;i<m;i++){
            for(int j = i;j<n;j++){   //注意这里是j = i!!!!!
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        //左右翻转
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-1-j] = tmp;
            }
        }
    }
}
