package Entry;

public class SpiralOrder {
    public static void main(String[] args) {



    }
}
class Solution29 {

    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int rows = matrix.length,columns = matrix[0].length;
        int[] order = new int[rows*columns];
        int index = 0;
        int left = 0,right = columns-1,top = 0,bottom = rows -1;
        while (left<=right && top<=bottom){
            //上
            for(int column = left;column<=right;column++){
                order[index++] = matrix[top][column];
            }
            //右
            for(int row = top+1;row<=bottom;row++){
                order[index++] = matrix[row][right];
            }
            //下 and 左
            if(left<right && top<bottom){
                for(int column = right-1;column>left;column--){
                    order[index++] = matrix[bottom][column];
                }
                for(int row = bottom;row>top;row--){
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    public int[] spiralOrder1(int[][] matrix){
        if(matrix == null || matrix.length == 0 ||matrix[0].length == 0)
            return new int[0];

        int row = matrix.length;
        int column = matrix[0].length;

        int[] res = new int[row*column];
        int top = 0,right = column-1,bottom = row-1,left = 0;
        int count = 0;
        while (top<=bottom && left<=right){
            //上
            for(int i = left;i<=right;i++){
                res[count++] = matrix[top][i];
            }
            //右
            for(int i = top+1;i<=bottom;i++){
                res[count++] = matrix[i][right];
            }

            if(left<right && top<bottom) {
                //下
                for (int i = right - 1; i >= (left + 1); i--) {
                    res[count++] = matrix[bottom][i];
                }
                //左
                for (int i = bottom; i >= (top + 1); i--) {
                    res[count++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;

        }
        return res;
    }

}