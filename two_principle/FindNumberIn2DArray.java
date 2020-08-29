package two_principle;

public class FindNumberIn2DArray {

    public static void main(String[] args) {
        int[][] nums = {{1,4,7,11,15},
                        {2,5,8,12,19},
                        {3,6,9,16,22},
                        {10,13,14,17,24},
                        {18,21,23,26,30}};

        int[][] nums1 = {{}};

        int target = 20;
        Solution04 s = new Solution04();
        System.out.println(s.findNumberIn2DArray(nums1,target));


    }
}

//giao 递归还是超限了
class Solution04 {
    private int[][] matrix;
    private int target;

    private boolean result ;

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;



        this.matrix = matrix;
        this.target = target;

        findNum(0,0);

        return result;



    }

    private void findNum(int i,int j){
        if(matrix[i][j] == target){
            result = true;
            return ;
        }

        if((j+1)<matrix[0].length) {
           findNum(i, j + 1);
        }
        if((i+1)<matrix.length) {
            findNum(i + 1, j);
        }
    }

}