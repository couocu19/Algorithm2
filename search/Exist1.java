package search;

public class Exist1 {
    public static void main(String[] args) {

    }
}

class Solution79s{

    private String word;
    private int len;
    private char[][] board;
    private int m;
    private int n;
    private boolean[][] marked;
    //上，左，右，下
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        //记录数组有多少行
         m = board.length;
        if (m == 0) {
            return false;
        }
        //记录数组有多少列
         n = board[0].length;
        //该数组用来标记被访问过的坐标点
         marked = new boolean[m][n];
         this.board = board;
         this.word = word;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;

    }


    public boolean dfs(int i ,int j ,int start){

        if(start == word.length()-1){
            return board[i][j] == word.charAt(start);
        }


        //每次函数调用的终止点
        if(board[i][j] == word.charAt(start)){
            marked[i][j] = true;

            for(int k =0;k<4;k++){

                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if( isOk(newX,newY)&&!marked[newX][newY]){
                    if(dfs(newX,newY,start+1)){
                        return true;
                    }

                }
            }
            //如果下一级的四个方向都返回false，则本级也设置为false
            marked[i][j] = false;

        }
        return false;
    }

    public boolean isOk(int x,int y){


        return (x>=0&&x<m && y>=0&&y<n);
    }


}

