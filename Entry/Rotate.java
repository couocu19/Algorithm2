package Entry;

public class Rotate {
    public static void main(String[] args) {



    }
}

class Solution48 {
    //思路：1.转置矩阵 2.反转每一行
    public void rotate(int[][] matrix) {
        int len1 = matrix.length;
        int len2 = matrix[0].length;

        for(int i =0;i<len1;i++){
            for(int j = i;j<len2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i =0;i<len1;i++){
            for(int j =0;j<len2/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len2-j-1];
                matrix[i][len2-j-1] = tmp;
            }
        }


    }
}