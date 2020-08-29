package two_principle;

public class FindNumberIn2DArray1 {
    public static void main(String[] args) {
        int[][] nums = {{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}};

        int target = 5;
        Solution04s s = new Solution04s();
        System.out.println(s.findNumberIn2DArray(nums,target));



    }

}
class Solution04s {


    /**
     * 这道题的关键点在于查找target的值时的起点从哪里开始，
     * 显然有左上角，右上角，左下角，右下角四个方向可以选择；
     * 但是左上角和右下角：两个方向走都是扩大或减小，所以不可行
     * 即右上角和左下角两个方向可选
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

       if(matrix == null ||matrix.length == 0||matrix[0].length == 0)
             return false;
       int i = matrix.length-1;
       int j = 0;
       int len = matrix.length;
       int len1 = matrix[0].length;
       while(i>=0 && j<len1){
           if(target == matrix[i][j])
               return true;

           if(matrix[i][j]>target)
               i--;
           else
               j++;

       }
       return false;
    }
}
