package review.backtrack;

public class Exist {

    public static void main(String[] args) {
        Solution12 s = new Solution12();
        char[][] board = {{'a','b','c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        String word = "bfce";
        System.out.println(s.exist(board,word));


    }
}

class Solution12 {


    char[][] board;
    char[] w;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.w = word.toCharArray();
        for(int i =0;i<board.length;i++){
            for(int j =0;j <board[0].length;j++){
                if(back(i,j,0))
                    return true;
            }

        }
        return false;
    }

    private boolean back(int i ,int j,int m){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=w[m]){
            return false;
        }

        if(m == w.length-1)
            return true;

        char tmp = board[i][j];
        board[i][j] = '/';

        boolean res = back(i+1,j,m+1)|| back(i-1,j,m+1) ||
                      back(i,j+1,m+1) || back(i,j-1,m+1);

        board[i][j] = tmp;

        return res;

    }
}
