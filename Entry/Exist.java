package Entry;

public class Exist {
    public static void main(String[] args) {

        char[][] board = {{'a','b','t','g'},{'c','f','c','s'},{'j','d','e','h'}};

        String word = "abtg";

        Solution12 s = new Solution12();
        System.out.println(s.exist(board,word));



    }
}

class Solution12 {
    private char[][] board;
    private String word;
    private boolean res = false;
    private boolean[][] flag;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int len = word.length();
        int len1 = board.length;
        int len2 = board[0].length;
        flag = new boolean[len1][len2];
        for(int i =0;i<len1;i++){
            for(int j =0;j<len2;j++){
                flag[i][j] = true;
            }
        }

        return back(0,0,0,0);
    }

    private void backtrack(int i,int j,int m){
            if (board[i][j] == word.charAt(m)) {
                if(m == word.length()-1){
                    res = true;
                    return;
                }
                m = m+1;
            }

           // if(i<board.length && j<board[0].length) {
                if ((i + 1) < board.length && flag[i + 1][j]) {
                    backtrack(i + 1, j, m);
                }
                if ((i - 1) >= 0 && flag[i - 1][j]) {
                    backtrack(i - 1, j, m);
                }

                if ((j + 1) < board[0].length && flag[i][j + 1]) {
                    backtrack(i, j + 1, m);
                }
                if ((j - 1) >= 0 && flag[i][j - 1]) {
                    backtrack(i, j - 1, m);
                }

                flag[i][j] = true;

            //}

        }


    //todo:改代码
    private boolean back(int i,int j,int m,int f){

          if(m == word.length()-1) {
              System.out.println("ok");
              return true;
          }


           if(f == (board.length*board[0].length))
               return false;

          if(i<board.length&&j<board[0].length&& flag[i][j] &&board[i][j] == word.charAt(m)) {
              System.out.println("ok1");
              flag[i][j] = false;
              f++;
             // m = m+1;

              boolean res = back(i+1,j,m+1,f)||back(i,j+1,m+1,f) ||
                      back(i-1,j,m+1,f)||back(i,j-1,m+1,f);

              flag[i][j] = true;

          }


//          boolean res =  back(i+1,j,m,f)||back(i,j+1,m,f) ||
//                 back(i-1,j,m,f)||back(i,j-1,m,f);

          return res;
    }



}





class Solution12s{

    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,words,i,j,0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i>=board.length || i<0 || j>=board[0].length|| j<0 || board[i][j]!=word[k])
            return false;
        if(k==word.length-1)
            return true;
        char tmp = board[i][j];
        board[i][j] = '/';

        boolean res = dfs(board,word,i+1,j,k+1) || dfs(board,word,i-1,j,k+1)||
                      dfs(board,word,i,j+1,k+1) || dfs(board,word,i,j-1,k+1);

        board[i][j] = tmp;
        return res;

    }
}

class Solution12ss{


    char[][] board;
    char[] w;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.w = word.toCharArray();
        char[] words = word.toCharArray();
        for(int i =0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(back(i,j,0))
                    return true;

            }

        }

        return false;

    }


    private boolean back(int i,int j,int m){

        if(i>=board.length || i<0 || j>=board[0].length || j<0 || w[m]!=board[i][j])
            return false;

        if(m == w.length-1)
            return true;

        char tmp = board[i][j];
        board[i][j] = '/';

        boolean res = back(i+1,j,m+1)||back(i,j+1,m+1)||
                      back(i-1,j,m+1)||back(i-1,j-1,m+1);
        board[i][j] = tmp;
        return res;
    }

}