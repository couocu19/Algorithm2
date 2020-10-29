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

}