package top100;

public class No79 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        Solution79 s = new Solution79();
        String word = "ABFDA";
        System.out.println(s.exist(board,word));


    }
}


//不行！
class Solution79 {
    public boolean exist(char[][] board, String word) {
        int len = word.length();
        if(len == 0)
            return false;
        StringBuilder flag = new StringBuilder("");
        int m = board.length-1;
        int n = board[0].length-1;
        return back(board,word,len,flag,0,0,m,n,0);
    }
    public boolean back(char[][] board, String word,int len,StringBuilder flag,int i,int j,int m,int n,int k){
        if(i>m || j>n)
            return false;
        if(flag.length() == len && flag.toString().equals(word)) ///可能需要修改
            return true;
        if(k<len && board[i][j] == word.charAt(k)){
            System.out.println(k);
            flag.append(board[i][j]);
            //System.out.println(flag.toString());
            k++;
        }
        return back(board,word,len,flag,i+1,j,m,n,k) || back(board,word,len,flag,i,j+1,m,n,k);
    }
}

//todo：把这个代码看懂，修改上一个代码！！
class Solution79s {
    char[][] board;
    char[] w;
    public boolean exist(char[][] board, String word){
        this.board = board;
        this.w = word.toCharArray();
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){

            }
        }

        return false;
    }

    private boolean find(int i, int j,int m){
        if(i<0 || i>=board.length || j<0 || j>board[0].length || board[i][j]!=w[m])
            return false;

        if(m == w.length-1)
            return true;

        char tmp = board[i][j];
        board[i][j] = '/'; //标记已经访问过的字符？？

        boolean res = find(i+1,j,m+1) || find(i-1,j,m+1) ||
                      find(i,j+1,m+1) || find(i,j-1,m+1);

        board[i][j] = tmp;

        return res;
    }




}